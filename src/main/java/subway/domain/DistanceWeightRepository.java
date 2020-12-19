package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceWeightRepository {

    private static WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public static void addStation(String station) {
        distanceGraph.addVertex(station);
    }

    public static void setStationEdgeDistance(String startStation, String endStation,
        int distance) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(startStation, endStation), distance);
    }


    public static List<String> getDijkstraShortestPath(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }
}
