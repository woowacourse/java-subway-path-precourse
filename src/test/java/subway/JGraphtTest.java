package subway;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;
import subway.domain.Station;

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
    public void 최단경로() {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        graph.addVertex(station1);
        graph.addVertex(station2);
        graph.addVertex(station3);
        graph.addEdge(station1, station2);
        graph.addEdge(station2, station3);

        graph.setEdgeWeight(station1, station2, 3);
        graph.setEdgeWeight(station2, station3, 5);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<Station> path = dijkstraShortestPath.getPath(station1, station3).getVertexList();
        path.stream()
            .map(s -> s.getName())
            .forEach(System.out::println);
    }
}
