package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.constants.DomainErrorMessage;

public class StationTimeRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    public void addStationTitle(String stationTitle) {
        timeGraph.addVertex(stationTitle);
    }

    public void addStationIntervalTime(String initialStation, String lastStation, int distance) {
        isSameInitialLastStation(initialStation, lastStation);
        DefaultWeightedEdge stationEdge = timeGraph.addEdge(initialStation, lastStation);
        timeGraph.setEdgeWeight(stationEdge, distance);
    }

    private void isSameInitialLastStation(String initialStation, String lasStation) {
        if (initialStation.equals(lasStation)) {
            System.out.println(DomainErrorMessage.SAME_STATION);
            throw new IllegalArgumentException(DomainErrorMessage.SAME_STATION);
        }
    }
}
