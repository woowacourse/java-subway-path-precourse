package subway;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.Test;

import java.util.List;
import subway.domain.Dijkstra.Cost;
import subway.domain.Dijkstra.DijkstraPath;
import subway.domain.Dijkstra.IntervalEdge;
import subway.domain.Dijkstra.RouteMap;
import subway.domain.Dijkstra.Station;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        /*WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");

        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();
        dijkstraShortestPath.getPath("v3", "v1").getEdgeList();
        WeightedMultigraph<Vertex, Edge> myGraph = new WeightedMultigraph<>(Edge.class);
        Vertex v1 = new Vertex(new Station("강남역"));
        Vertex v2 = new Vertex(new Station("역삼역"));
        myGraph.addVertex(v1);
        myGraph.addVertex(v2);
        myGraph.setEdgeWeight(myGraph.addEdge(v1, v2), 5);

        assertThat(shortestPath.size()).isEqualTo(3);*/
        RouteMap routeMap = new RouteMap();
        Station s1 = new Station("강남역");
        Station s2 = new Station("역삼역");

        IntervalEdge intervalEdge = new IntervalEdge(s1, s2, new Cost(10, 20));
        routeMap.addStation(s1);
        routeMap.addStation(s2);

        routeMap.addInterval(s1, s2, 10);

        DijkstraPath dijkstraPath = new DijkstraPath(routeMap);
        List<Station> stations = dijkstraPath.getStationsPassing(s1, s2);
        List<DefaultWeightedEdge> Edges = dijkstraPath.getIntervalsPassing(s1, s2);
        for(Station station: stations) {
            System.out.println(station.getName());
        }

        for(DefaultWeightedEdge edge: Edges) {
            System.out.println(routeMap.getEdgeSourceName(edge));

        }

        System.out.println("dsdsdsdsdsd");

    }
}
