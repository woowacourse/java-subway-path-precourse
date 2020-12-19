package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class GraphByDistance {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    public static WeightedMultigraph getGraph() {
        return graph;
    }

    public static void addVertex(String station) {
        graph.addVertex(station);
    }

    public static void setEdgeWeight(String from, String to, int distance) {
        graph.setEdgeWeight(graph.addEdge(from, to), distance);
    }

    public static List<String> checkShortestPath(String from, String to) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(from, to).getVertexList();
        return shortestPath;
    }

    public static int getShortestPathDistanceTime(String from, String to) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        int totalTime = 0;
        for(Object edge: dijkstraShortestPath.getPath(from, to).getEdgeList()){
            totalTime += GraphByTime.getGraph().getEdgeWeight(edge);
        }
        return totalTime;
    }

    public static int checkShortestPathDistance(String from, String to) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return (int) dijkstraShortestPath.getPathWeight(from, to);
    }
}
