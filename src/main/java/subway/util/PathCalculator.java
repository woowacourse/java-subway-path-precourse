package subway.util;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathCalculator {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addStation(String name) {
        timeGraph.addVertex(name);
        distanceGraph.addVertex(name);
    }

    public static void addWeightInfo(String startStation, String arrivedStation, int distance, int time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(startStation, arrivedStation), time);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(startStation, arrivedStation), distance);
    }

}
