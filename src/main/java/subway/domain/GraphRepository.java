package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class GraphRepository {
    private WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public WeightedMultigraph<String, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public void addVertex(String stationName) {
        graph.addVertex(stationName);
    }

    public void setWeight(String v1, String v2, int weight) {
        graph.setEdgeWeight(graph.addEdge(v1, v2), weight);
    }

    public List<String> calPath(String source, String destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(source, destination).getVertexList();
        return shortestPath;
    }

}
