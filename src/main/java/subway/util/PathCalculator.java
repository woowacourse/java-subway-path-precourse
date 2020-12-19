package subway.util;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class PathCalculator {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static void addStation(String name) {
        timeGraph.addVertex(name);
        distanceGraph.addVertex(name);
    }

    public static void addWeightInfo(String startStation, String arrivedStation, int distance, int time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(startStation, arrivedStation), time);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(startStation, arrivedStation), distance);
    }

    public static List<String> calculateShortestDistancePath(String startStation, String arrivedStation) {
        DijkstraShortestPath shortestDistancePath = new DijkstraShortestPath(distanceGraph);
        return shortestDistancePath.getPath(startStation, arrivedStation).getVertexList();
    }

    public static List<String> calculateShortestTimePath(String startStation, String arrivedStation) {
        DijkstraShortestPath shortestDistancePath = new DijkstraShortestPath(timeGraph);
        return shortestDistancePath.getPath(startStation, arrivedStation).getVertexList();
    }

}
