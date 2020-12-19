package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceMap {
    WeightedMultigraph<Station, DefaultWeightedEdge> distanceMap
        = new WeightedMultigraph(DefaultWeightedEdge.class);

    public void addStationVertex(List<Station> stations) {
        stations.stream()
            .forEach(station -> distanceMap.addVertex(station));
    }

    public void addWeight(Section section, int distance) {
        distanceMap.setEdgeWeight(,distance);
    }
}
