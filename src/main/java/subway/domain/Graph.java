package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class Graph {

    private final WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private final DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);

    public Graph() {
    }

    public double shortestPathWeight(Station v1, Station v2) {
        return dijkstraShortestPath.getPath(v1, v2).getWeight();
    }

    public List<Station> shortestPath(Station v1, Station v2) {
        return dijkstraShortestPath.getPath(v1, v2).getVertexList();
    }

    public void makeConnection(Station v1, Station v2, double weight) {
        try {
            graph.addVertex(v1);
            graph.addVertex(v2);

            graph.setEdgeWeight(graph.addEdge(v1, v2), weight);
            graph.setEdgeWeight(graph.addEdge(v2, v1), weight);
        } catch (Exception e) {
            System.out.println("ddd");
        }
    }
}
