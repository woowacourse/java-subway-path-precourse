package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistanceGraphRepository {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addStation(Station station) {
        distanceGraph.addVertex(station);
    }

    public static void addTimeBetweenStations(Station source, Station destination, int time) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(source, destination), time);
    }
}
