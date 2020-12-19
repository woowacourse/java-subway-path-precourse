package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;


public class TimeGraphRepository {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addStation(Station station) {
        timeGraph.addVertex(station);
    }

    public static void addTimeBetweenStations(Station source, Station destination, int time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(source, destination), time);
    }
}
