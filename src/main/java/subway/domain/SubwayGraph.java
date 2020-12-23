package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.repository.StationRepository;

import java.util.List;

public interface SubwayGraph {
    String NOT_CONNECTED_STATION_MESSAGE = "\n[ERROR] 두 역은 연결되지 않았습니다.\n";

    WeightedMultigraph<Station, DefaultWeightedEdge> subwayGraph
        = new WeightedMultigraph(DefaultWeightedEdge.class);

    default void addStationVertex() {
        StationRepository.stations()
            .forEach(subwayGraph::addVertex);
    }

    default WeightedMultigraph getGraph() {
        return subwayGraph;
    }

    default void isConnectedMap(GraphPath shortestPath) {
        if (shortestPath == null) {
            throw new IllegalArgumentException(NOT_CONNECTED_STATION_MESSAGE);
        }
    }

    void addWeight();
    List<Station> getShortestRoute(WeightedMultigraph graph, Station firstStation, Station secondStation);
}
