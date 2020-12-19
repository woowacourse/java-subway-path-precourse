package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;
import subway.domain.Dijkstra.DijkstraPath;
import subway.domain.Dijkstra.RouteMap;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");

        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();
        dijkstraShortestPath.getPath("v3", "v1").getEdgeList();
        /*WeightedMultigraph<Vertex, Edge> myGraph = new WeightedMultigraph<>(Edge.class);
        Vertex v1 = new Vertex(new Station("강남역"));
        Vertex v2 = new Vertex(new Station("역삼역"));
        myGraph.addVertex(v1);
        myGraph.addVertex(v2);
        myGraph.setEdgeWeight(myGraph.addEdge(v1, v2), 5); */

        assertThat(shortestPath.size()).isEqualTo(3);
        RouteMap routeMap = new RouteMap();

        DijkstraPath dijkstraPath = new DijkstraPath(routeMap);
    }
}
