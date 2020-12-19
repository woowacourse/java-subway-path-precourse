package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayGraph {
    WeightedMultigraph<Station, DefaultWeightedEdge> distanceWeightGraph;
    WeightedMultigraph<Station, DefaultWeightedEdge> timeWeightGraph;


    public SubwayGraph() {
        this.distanceWeightGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        this.timeWeightGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    }

    public void addVertices(List<Station> stations) {
        for (Station station : stations) {
            distanceWeightGraph.addVertex(station);
            timeWeightGraph.addVertex(station);
        }
    }
}
