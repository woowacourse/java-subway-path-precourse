package subway.model.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimeRepository {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public void addStation(Station station) {
        timeGraph.addVertex(station.getName());
    }

    public void addTime(Station from, Station to, int time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(from.getName(), to.getName()), time);
    }

    public static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph() {
        return timeGraph;
    }

    public static double getWeight(String from, String to) {
        return timeGraph.getEdgeWeight(timeGraph.getEdge(from, to));
    }
}
