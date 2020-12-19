package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class GraphByDistance {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph =
            new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);

    public static WeightedMultigraph getGraph() {
        return graph;
    }

    public static void addVertex(String station) {
        graph.addVertex(station);
    }

    public static void setEdgeWeight(String from, String to, int distance) {
        graph.setEdgeWeight(graph.addEdge(from, to), distance);
    }

    public static List<String> getShortestPathByDistance(String from, String to) {
        List<String> shortestPath = dijkstraShortestPath.getPath(from, to).getVertexList();
        return shortestPath;
    }

    public static int getTimeOfShortestPathByDistance(String from, String to) {
        WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = GraphByTime.getGraph();
        int totalTime = dijkstraShortestPath
                .getPath(from, to)
                .getEdgeList()
                .stream()
                .mapToInt(edge -> (int) timeGraph
                        .getEdgeWeight((DefaultWeightedEdge) edge))
                        .sum();
        return totalTime;
    }

    public static int getDistanceOfShortestPathByDistance(String from, String to) {
        return (int) dijkstraShortestPath.getPathWeight(from, to);
    }
}
