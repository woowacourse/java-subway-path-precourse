package subway;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();

        assertThat(shortestPath.size()).isEqualTo(3);
    }

    @Test
    public void 학습_테스트() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.addVertex("v4");
        graph.addVertex("v5");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 7);
        graph.setEdgeWeight(graph.addEdge("v1", "v4"), 8);
        graph.setEdgeWeight(graph.addEdge("v1", "v5"), 5);

        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v4"), 4);
        graph.setEdgeWeight(graph.addEdge("v2", "v5"), 8);

        graph.setEdgeWeight(graph.addEdge("v3", "v4"), 11);
        graph.setEdgeWeight(graph.addEdge("v3", "v5"), 7);

        graph.setEdgeWeight(graph.addEdge("v4", "v5"), 8);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);

        GraphPath path = dijkstraShortestPath.getPath("v4", "v1");
        List<String> shortestPath = path.getVertexList();
        System.out.println(shortestPath);

        assertThat(shortestPath.size()).isEqualTo(3);
    }
}
