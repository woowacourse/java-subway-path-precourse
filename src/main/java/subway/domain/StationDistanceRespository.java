package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.constants.DomainErrorMessage;

public class StationDistanceRespository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> spaceGraph =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addStationTitle(String stationTitle) {
        spaceGraph.addVertex(stationTitle);
    }

    public static void addStationIntervalDistance(String initialStation,
            String lastStation, int distance) {
        isSameInitialLastStation(initialStation, lastStation);
        DefaultWeightedEdge stationEdge = spaceGraph.addEdge(initialStation, lastStation);
        spaceGraph.setEdgeWeight(stationEdge, distance);
    }

    private static void isSameInitialLastStation(String initialStation, String lasStation) {
        if (initialStation.equals(lasStation)) {
            System.out.println(DomainErrorMessage.SAME_STATION);
            throw new IllegalArgumentException(DomainErrorMessage.SAME_STATION);
        }
    }
}
