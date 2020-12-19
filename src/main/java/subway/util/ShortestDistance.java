package subway.util;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class ShortestDistance {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addVertex(List<Station> stations) {
        for (Station station : stations) {
            graph.addVertex(station.getName());
        }
    }

    public static void setEdgeWeight(String stationName, String nextStationName, int street) {
        graph.setEdgeWeight(graph.addEdge(stationName, nextStationName), street);
    }

    public static List<String> getStations(String startStation, String finishStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        //todo: 없을 경우 예외 처리
        return dijkstraShortestPath.getPath(startStation, finishStation).getVertexList();
    }
}
