package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.exception.TransitRouteException;

import java.util.List;

public class GraphByTime {
    private static final String ERROR_STATIONS_NOT_CONNECTED = "출발역과 도착역이 연결되어 있지 않습니다";

    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph =
            new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final DijkstraShortestPath shortestTimeGraph = new DijkstraShortestPath(graph);

    public static WeightedMultigraph getGraph() {
        return graph;
    }

    public static void addVertex(String station) {
        graph.addVertex(station);
    }

    public static void setEdgeWeight(String from, String to, int time) {
        graph.setEdgeWeight(graph.addEdge(from, to), time);
    }

    public static List<String> getShortestPathByTime(String from, String to) {
        List<String> shortestPath = shortestTimeGraph.getPath(from, to).getVertexList();
        if(shortestPath.isEmpty()){
            throw new TransitRouteException(ERROR_STATIONS_NOT_CONNECTED);
        }
        return shortestPath;
    }

    public static int getDistanceOfShortestPathByTime(String from, String to) {
        WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = GraphByDistance.getGraph();
        int totalDistance = shortestTimeGraph
                .getPath(from, to)
                .getEdgeList()
                .stream()
                .mapToInt(edge -> (int) distanceGraph
                        .getEdgeWeight((DefaultWeightedEdge) edge))
                        .sum();
        return totalDistance;
    }

    public static int getTimeOfShortestPathByTime(String from, String to) {
        return (int) shortestTimeGraph.getPathWeight(from, to);
    }
}
