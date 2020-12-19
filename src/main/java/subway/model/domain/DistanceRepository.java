package subway.model.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistanceRepository {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public void addStation(Station station) {
        distanceGraph.addVertex(station.getName());
    }

    public void addDistance(Station source, Station target, int distance) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(source.getName(), target.getName()), distance);
    }

    public static WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph() {
        return distanceGraph;
    }

    public static double getWeight(String from, String to) {
        return distanceGraph.getEdgeWeight(distanceGraph.getEdge(from, to));
    }
}
