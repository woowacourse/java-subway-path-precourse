package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.constants.DomainErrorMessage;

public class StationTimeRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph =
            new WeightedMultigraph(DefaultWeightedEdge.class);
    private static DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);

    public static void addStationTitle(String stationTitle) {
        timeGraph.addVertex(stationTitle);
    }

    public static void addStationIntervalTime(String initialStation,
            String lastStation, int distance) {
        isSameInitialLastStation(initialStation, lastStation);
        DefaultWeightedEdge stationEdge = timeGraph.addEdge(initialStation, lastStation);
        timeGraph.setEdgeWeight(stationEdge, distance);
    }

    public static List<String> getShortestPath(String initialStation, String lastStation) {
        isSameInitialLastStation(initialStation, lastStation);
        List<String> shortestPath = dijkstraShortestPath.getPath(initialStation, lastStation)
                .getVertexList();
        return shortestPath;
    }

    public static int getShortestTime(String initialStation, String lastStation) {
        isSameInitialLastStation(initialStation, lastStation);
        try {
            int shortestTime = (int) dijkstraShortestPath.getPath(initialStation, lastStation)
                    .getWeight();
            return shortestTime;
        } catch (Exception error) {
            System.out.println(DomainErrorMessage.NO_CONNECT);
            throw new IllegalArgumentException(DomainErrorMessage.NO_CONNECT);
        }
    }

    private static void isSameInitialLastStation(String initialStation, String lasStation) {
        if (initialStation.equals(lasStation)) {
            System.out.println(DomainErrorMessage.SAME_STATION);
            throw new IllegalArgumentException(DomainErrorMessage.SAME_STATION);
        }
    }

}
