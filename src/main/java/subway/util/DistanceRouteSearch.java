package subway.util;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceRouteSearch {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static void addVertex(String stationName) {
        distanceGraph.addVertex(stationName);
    }

    public static void addDistanceEdgeWeight(String station1, String station2, int distance) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(station1, station2), distance);
    }

    public static List<String> getShortestRoute(String startStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        return dijkstraShortestPath.getPath(startStation, arrivalStation).getVertexList();
    }
}
