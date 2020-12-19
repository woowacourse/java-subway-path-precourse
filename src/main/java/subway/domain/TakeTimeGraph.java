package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TakeTimeGraph {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addVertex(Station station) {
        graph.addVertex(station);
    }

    public static void addEdgeByTime(Station station, Station next, int time) {
        graph.setEdgeWeight(graph.addEdge(station, next), time);
    }

    public static WeightedMultigraph getGraph() {
        return graph;
    }
}
