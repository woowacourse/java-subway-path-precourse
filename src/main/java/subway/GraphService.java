package subway;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.domain.StationRepository;

public class GraphService {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> GRAPH_DISTANCE = new WeightedMultigraph(
        DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> GRAPH_TIME = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public static void init() {
        for (String stationName : DataInitService.stationNames) {
            GRAPH_DISTANCE.addVertex(stationName);
            GRAPH_TIME.addVertex(stationName);
        }
        for (String stationName : DataInitService.stationNames) {
            Station station = StationRepository.getStation(stationName);
            for (ConnectData connectData : station.ConnectDataList()) {
                GRAPH_DISTANCE.setEdgeWeight(
                    GRAPH_DISTANCE.addEdge(stationName, connectData.getStation().getName()),
                    connectData.getDistance());
                GRAPH_DISTANCE.setEdgeWeight(
                    GRAPH_TIME.addEdge(stationName, connectData.getStation().getName()),
                    connectData.getTime());
            }
        }
    }

}
