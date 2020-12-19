package subway.domain.graph;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

/*
최단 시간을 가중치로 둔 그래프
 */
public class TimeGraph {
    WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static String line;

    public TimeGraph(String line, List<String> stations) {
        stations.forEach(station -> graph.addVertex(station));
    }

    public static TimeGraph valueOf(String line, List<String> stations) {
        return new TimeGraph(line, stations);
    }

    public void setEge(String station, String nextStation, int time) {
        graph.setEdgeWeight(graph.addEdge(station, nextStation), time);
    }
}
// DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
//        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();
//         System.out.println(dijkstraShortestPath.getPath(station, nextStation).getWeight());