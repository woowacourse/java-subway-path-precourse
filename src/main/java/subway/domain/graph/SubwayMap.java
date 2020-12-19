package subway.domain.graph;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.StationRepository;

import java.util.List;

public class SubwayMap {
    private static WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void setStations(List<String> stations) {
        stations.stream()
                .forEach(station -> distanceGraph.addVertex(station));

        stations.stream()
                .forEach(station -> timeGraph.addVertex(station));
    }

    public static void setEdgeDistance(List<String> stations, int distance, int time) {
        String firstStation = stations.get(StationRepository.FIRST_STATION_INDEX);
        String lastStation = stations.get(StationRepository.LAST_STATION_INDEX);
        distanceGraph.setEdgeWeight(firstStation, lastStation, distance);
        timeGraph.setEdgeWeight(firstStation, lastStation, time);
    }


}
