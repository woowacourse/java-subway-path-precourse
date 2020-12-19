package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SearchGraph {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> graphByDistance;
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> graphByTime;

    static {
        graphByDistance = new WeightedMultigraph(DefaultWeightedEdge.class);
        graphByTime = new WeightedMultigraph(DefaultWeightedEdge.class);
    }

    private SearchGraph() {
    }

    public static void addVertex(Station station) {
        graphByDistance.addVertex(station);
        graphByTime.addVertex(station);
    }

    public static void addEdgeByDistance(Station station, Station next, int distance) {
        graphByDistance.setEdgeWeight(graphByDistance.addEdge(station, next), distance);
    }

    public static void addEdgeByTime(Station station, Station next, int time) {
        graphByTime.setEdgeWeight(graphByTime.addEdge(station, next), time);
    }

    public static WeightedMultigraph getGraphByDistance() {
        return graphByDistance;
    }

    public static WeightedMultigraph getGraphByTime() {
        return graphByTime;
    }
}
