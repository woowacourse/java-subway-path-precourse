package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.domain.Station;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    public void testWhetherStartAndEndStationsAreConnected() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("교대역");
        graph.addVertex("강남역");
        graph.addVertex("매봉역");
        graph.addVertex("서울역");
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 2);
        graph.setEdgeWeight(graph.addEdge("강남역", "매봉역"), 2);
        graph.setEdgeWeight(graph.addEdge("매봉역", "교대역"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        assertThatThrownBy(() -> dijkstraShortestPath.getPath("교대역", "서울역").getVertexList())
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    public void testWhetherStartOrEndStationsAreEnrolled_true() {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex(new Station("교대역"));
        graph.addVertex(new Station("강남역"));
        graph.addVertex(new Station("매봉역"));
        graph.addVertex(new Station("서울역"));

        Station start = new Station("교대역");

        Assertions.assertTrue(graph.containsVertex(start));
    }

    @Test
    public void testWhetherStartOrEndStationsAreEnrolled_false() {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex(new Station("교대역"));
        graph.addVertex(new Station("강남역"));
        graph.addVertex(new Station("매봉역"));
        graph.addVertex(new Station("서울역"));

        Station start = new Station("남부터미널역");

        Assertions.assertFalse(graph.containsVertex(start));
    }
}
