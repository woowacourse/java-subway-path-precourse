package subway.repository;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Stations;

public class TimeMapRepository {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeMap
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static WeightedMultigraph<String, DefaultWeightedEdge> timeMap() {
        return timeMap;
    }

    public static void addStationForTimeMap(String stationName) {
        timeMap.addVertex(stationName);
    }

    public static void connectStationsWithTime(Stations stations, int time) {
        timeMap.setEdgeWeight(
                timeMap.addEdge(
                        stations.getUpStationName(), stations.getDownStationName()), time);
    }
}
