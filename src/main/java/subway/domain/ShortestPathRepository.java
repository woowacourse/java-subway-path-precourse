package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class ShortestPathRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
        DefaultWeightedEdge.class);
    private static DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);

    public static void addGraphVertex(String vertex) {
        graph.addVertex(vertex);
    }

    public static void setGraphEdgeWeight(String sourceVertex, String targetVertex, int weight){
        graph.setEdgeWeight(graph.addEdge(sourceVertex, targetVertex), weight);
    }

    public static List<String> getShortestPath(String source, String sink){
        List<String> shortestPath = dijkstraShortestPath.getPath(source, sink).getVertexList();
        return shortestPath;
    }

    public static double getShortestDistance(String source, String sink) {
        double weight =dijkstraShortestPath.getPath(source, sink).getWeight();
        return weight;
    }

}
