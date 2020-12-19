package subway.graph;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceWeightedGraph {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addVertex(String vertex) {
        graph.addVertex(vertex);
    }

    public static DefaultWeightedEdge addEdge(String source, String destination) {
        return graph.addEdge(source, destination);
    }

    public static void setEdgeWeight(DefaultWeightedEdge DWE, double weight) {
        graph.setEdgeWeight(DWE, weight);
    }

    public static List<String> getOptimalGraph(String source, String destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> optimalGraph = dijkstraShortestPath.getPath(source, destination).getVertexList();
        return optimalGraph;
    }

}
