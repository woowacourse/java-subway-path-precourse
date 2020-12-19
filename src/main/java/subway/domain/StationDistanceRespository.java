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
            String terminalStation, int distance) {
        isSameInitialLastStation(initialStation, terminalStation);
        DefaultWeightedEdge stationEdge = spaceGraph.addEdge(initialStation, terminalStation);
        spaceGraph.setEdgeWeight(stationEdge, distance);
    }

    public static List<String> getShortestPath(String initialStation, String terminalStation) {
        isSameInitialLastStation(initialStation, terminalStation);
        List<String> shortestPath = dijkstraShortestPath.getPath(initialStation, terminalStation)
                .getVertexList();
        return shortestPath;
    }

    public static int getShortestDistance(String initialStation, String terminalStation) {
        isSameInitialLastStation(initialStation, terminalStation);

        try {
            return (int) dijkstraShortestPath.getPath(initialStation, terminalStation)
                    .getWeight();
        } catch (Exception error) {
            System.out.println(DomainErrorMessage.NO_CONNECT);
            throw new IllegalArgumentException(DomainErrorMessage.NO_CONNECT);
        }
    }

    private static void isSameInitialLastStation(String initialStation, String terminalStation) {
        if (initialStation.equals(terminalStation)) {
            System.out.println(DomainErrorMessage.SAME_STATION);
            throw new IllegalArgumentException(DomainErrorMessage.SAME_STATION);
        }
    }
}
