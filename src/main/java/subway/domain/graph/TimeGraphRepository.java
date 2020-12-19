package subway.domain.graph;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimeGraphRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static DijkstraShortestPath getQuickestPath() {
        return new DijkstraShortestPath(timeGraph);
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

    public static int totalTime(List<String> chosenPath) {
        int totalTime = 0;
        for (int currentStation = 0; currentStation < chosenPath.size() - 1; ++currentStation) {
            final DefaultWeightedEdge individualEdge = getEdge(chosenPath, currentStation);
            final int edgeWeight = getTime(individualEdge);

            totalTime += edgeWeight;
        }
        return totalTime;
    }

    private static DefaultWeightedEdge getEdge(List<String> chosenPath, int current) {
        return timeGraph.getEdge(chosenPath.get(current), chosenPath.get(current + 1));
    }

    private static int getTime(DefaultWeightedEdge individualEdge) {
        return (int)timeGraph.getEdgeWeight(individualEdge);
    }
}
