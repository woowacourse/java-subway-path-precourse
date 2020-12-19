package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class PathTimeWeight {
    private WeightedMultigraph<Station, DefaultWeightedEdge> pathTime =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    public PathTimeWeight(List<Station> stations, List<Integer> times) {
        addStation(stations);
        addStationDistance(stations, times);
    }

    private void addStation(List<Station> stations) {
        for (Station station : stations) {
            pathTime.addVertex(station);
        }
    }

    private void addStationDistance(List<Station> stations, List<Integer> times) {
        for (int i = 0; i < stations.size() - 1; i++) {
            pathTime.setEdgeWeight(
                    pathTime.addEdge(stations.get(i), stations.get(i + 1)),
                    times.get(i)
            );
        }
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getPathDistance() {
        return pathTime;
    }
}
