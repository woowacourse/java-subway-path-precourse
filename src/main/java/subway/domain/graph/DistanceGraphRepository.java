package subway.domain.graph;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistanceGraphRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static DijkstraShortestPath getShortestPath() {
        return new DijkstraShortestPath(distanceGraph);
    }

    public static void addStationsWithDistance(String firstStation, String secondStation,
            int distance) {
        addStation(firstStation);
        addStation(secondStation);
        addDistance(firstStation, secondStation, distance);
    }

    private static void addStation(String stationName) {
        distanceGraph.addVertex(stationName);
    }

    private static void addDistance(String firstStation, String secondStation, int distance) {
        final DefaultWeightedEdge newEdge = distanceGraph.addEdge(firstStation, secondStation);
        distanceGraph.setEdgeWeight(newEdge, distance);
    }

    public static int totalDistance(List<String> chosenPath) {
        int totalDistance = 0;
        for (int currentStation = 0; currentStation < chosenPath.size() - 1; ++currentStation) {
            final DefaultWeightedEdge individualEdge = getEdge(chosenPath, currentStation);
            final int edgeWeight = getDistance(individualEdge);

            totalDistance += edgeWeight;
        }
        return totalDistance;
    }

    private static DefaultWeightedEdge getEdge(List<String> chosenPath, int current) {
        return distanceGraph.getEdge(chosenPath.get(current), chosenPath.get(current + 1));
    }

    private static int getDistance(DefaultWeightedEdge individualEdge) {
        return (int) distanceGraph.getEdgeWeight(individualEdge);
    }
}
