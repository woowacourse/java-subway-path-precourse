package subway.util;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class TimeRouteSearch {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static void addVertex(String stationName) {
        timeGraph.addVertex(stationName);
    }

    public static void addDistanceEdgeWeight(String station1, String station2, int distance) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(station1, station2), distance);
    }

    public static List<String> getShortestRoute(String startStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        return dijkstraShortestPath.getPath(startStation, arrivalStation).getVertexList();
    }
}
