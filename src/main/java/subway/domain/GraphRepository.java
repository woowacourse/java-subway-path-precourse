package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class GraphRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static WeightedMultigraph<String, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public static void addVertex(String stationName) {
        graph.addVertex(stationName);
    }

    public static void setWeight(String v1, String v2, int weight) {
        graph.setEdgeWeight(graph.addEdge(v1, v2), weight);
    }

    public static List<String> calPath(String source, String destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(source, destination).getVertexList();
        return shortestPath;
    }

}
