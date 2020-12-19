package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistanceGraphRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static DijkstraShortestPath getShortestPath() {
        return new DijkstraShortestPath(distanceGraph);
    }

    private static Graph getGraph() {
        return distanceGraph;
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
}
