package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Graph {

    private final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private final DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);

    public Graph() {
    }

    public double shortestPath(String v1, String v2) {
        return dijkstraShortestPath.getPath(v1, v2).getWeight();
    }

    public void makeConnection(String v1, String v2, double weight) {
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.setEdgeWeight(graph.addEdge(v1, v2), weight);
        graph.setEdgeWeight(graph.addEdge(v2, v1), weight);
    }
}
