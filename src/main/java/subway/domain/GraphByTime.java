package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class GraphByTime {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph =
            new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);

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
        List<String> shortestPath = dijkstraShortestPath.getPath(from, to).getVertexList();
        return shortestPath;
    }

    public static int getDistanceOfShortestPathByTime(String from, String to) {
        WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = GraphByDistance.getGraph();
        int totalDistance = dijkstraShortestPath
                .getPath(from, to)
                .getEdgeList()
                .stream()
                .mapToInt(edge -> (int) distanceGraph
                        .getEdgeWeight((DefaultWeightedEdge) edge))
                        .sum();
        return totalDistance;
    }

    public static int getTimeOfShortestPathByTime(String from, String to) {
        return (int) dijkstraShortestPath.getPathWeight(from, to);
    }
}
