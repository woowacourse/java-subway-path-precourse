package subway.repository;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.Stations;

public class DistanceMapRepository {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceMap
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static WeightedMultigraph<String, DefaultWeightedEdge> distanceMap() {
        return distanceMap;
    }

    public static void addStationForDistanceMap(String stationName) {
        distanceMap.addVertex(stationName);
    }

    public static void connectStationsWithDistance(Stations stations, int distance) {
        distanceMap.setEdgeWeight(
                distanceMap.addEdge(
                        stations.getUpStationName(), stations.getDownStationName()), distance);
    }
}
