package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistanceGraph {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addVertex(Station station) {
        graph.addVertex(station);
    }

    public static void addEdgeByDistance(Station station, Station next, int distance) {
        graph.setEdgeWeight(graph.addEdge(station, next), distance);
    }

    public static WeightedMultigraph getGraph() {
        return graph;
    }
}
