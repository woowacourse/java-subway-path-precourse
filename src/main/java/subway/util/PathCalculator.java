package subway.util;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class PathCalculator {
    private static final String CONNECTION_NOT_FOUND_WARN = "[ERROR] 출발역과 도착역이 연결되어 있지 않습니다.";
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addStation(String name) {
        timeGraph.addVertex(name);
        distanceGraph.addVertex(name);
    }

    public static void addWeightInfo(String startStation, String endStation, int distance, int time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(startStation, endStation), time);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(startStation, endStation), distance);
    }

    public static List<String> calculateShortestDistancePath(String startStation, String endStation) {
        List<String> distancePath = new ArrayList<>();
        try {
            DijkstraShortestPath shortestDistancePath = new DijkstraShortestPath(distanceGraph);
            distancePath = shortestDistancePath.getPath(startStation, endStation).getVertexList();
        } catch (Exception e) {
            throw new IllegalArgumentException(CONNECTION_NOT_FOUND_WARN);
        }
        return distancePath;
    }

    public static List<String> calculateShortestTimePath(String startStation, String endStation) {
        List<String> timePath = new ArrayList<>();
        try {
            DijkstraShortestPath shortestDistancePath = new DijkstraShortestPath(timeGraph);
            timePath = shortestDistancePath.getPath(startStation, endStation).getVertexList();
        } catch (Exception e) {
            throw new IllegalArgumentException(CONNECTION_NOT_FOUND_WARN);
        }
        return timePath;
    }

}
