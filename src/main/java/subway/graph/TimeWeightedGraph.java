package subway.graph;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimeWeightedGraph {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addVertex(String vertex) {
        graph.addVertex(vertex);
    }

    public static DefaultWeightedEdge addEdge(String source, String destination) {
        return graph.addEdge(source, destination);
    }

    public static void setEdgeWeight(DefaultWeightedEdge e, double weight) {
        graph.setEdgeWeight(e, weight);
    }
}
