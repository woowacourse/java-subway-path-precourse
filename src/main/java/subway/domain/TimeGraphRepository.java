package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimeGraphRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static DijkstraShortestPath getQuickestPath() {
        return new DijkstraShortestPath(timeGraph);
    }

    private static Graph getGraph() {
        return timeGraph;
    }

    public static void addStationsWithTime(String firstStation, String secondStation, int time) {
        addStation(firstStation);
        addStation(secondStation);
        addTime(firstStation, secondStation, time);
    }

    private static void addStation(String stationName) {
        timeGraph.addVertex(stationName);
    }

    private static void addTime(String firstStation, String secondStation, int time) {
        final DefaultWeightedEdge newEdge = timeGraph.addEdge(firstStation, secondStation);
        timeGraph.setEdgeWeight(newEdge, time);
    }
}
