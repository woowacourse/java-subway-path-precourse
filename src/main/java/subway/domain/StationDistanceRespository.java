package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.constants.DomainErrorMessage;

public class StationDistanceRespository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> spaceGraph =
            new WeightedMultigraph(DefaultWeightedEdge.class);
    private static DijkstraShortestPath dijkstraShortestPath =
            new DijkstraShortestPath(spaceGraph);

    public static void addStationTitle(String stationTitle) {
        spaceGraph.addVertex(stationTitle);
    }

    public static void addStationIntervalDistance(String initialStation,
            String lastStation, int distance) {
        isSameInitialLastStation(initialStation, lastStation);
        DefaultWeightedEdge stationEdge = spaceGraph.addEdge(initialStation, lastStation);
        spaceGraph.setEdgeWeight(stationEdge, distance);
    }

    public static List<String> getShortestPath(String initialStation, String lastStation) {
        isSameInitialLastStation(initialStation, lastStation);
        List<String> shortestPath = dijkstraShortestPath.getPath(initialStation, lastStation)
                .getVertexList();
        return shortestPath;
    }

    public static int getShortestDistance(String initialStation, String lastStation) {
        isSameInitialLastStation(initialStation, lastStation);
        try {
            int shortestDistance = (int) dijkstraShortestPath.getPath(initialStation, lastStation)
                    .getWeight();
            return shortestDistance;
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
