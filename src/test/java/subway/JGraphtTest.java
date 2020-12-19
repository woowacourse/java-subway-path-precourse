 package subway;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;
import subway.domain.Station;

import java.util.ArrayList;
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
        ArrayList<String> strings = new ArrayList<>(shortestPath);
        strings.forEach(System.out::println);
    }

    @Test
    public void DijkstraTest() throws Exception{
        //given
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        Station station1 = new Station("하이역");
        Station station2 = new Station("회룡역");
        Station station3 = new Station("서울역");

        graph.addVertex(station1);
        graph.addVertex(station2);
        graph.addVertex(station3);

        graph.setEdgeWeight(graph.addEdge(station1, station2), 4);
        graph.setEdgeWeight(graph.addEdge(station2, station3), 6);
        graph.setEdgeWeight(graph.addEdge(station1, station3), 3);
        //when
        DijkstraShortestPath<Station, DefaultWeightedEdge> result = new DijkstraShortestPath<>(graph);
        GraphPath<Station, DefaultWeightedEdge> path = result.getPath(station1, station3);

        Graph<Station, DefaultWeightedEdge> graph1 = path.getGraph();
        System.out.println(path.getVertexList());

        List<Station> vertexList = path.getVertexList();

        //then
    }
}
