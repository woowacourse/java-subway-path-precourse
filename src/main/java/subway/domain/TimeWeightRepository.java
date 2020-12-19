package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class TimeWeightRepository {

    private static WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public static void addStation(String station) {
        timeGraph.addVertex(station);
    }

    public static void setStationEdgeTime(String startStation, String endStation, int time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(startStation, endStation), time);

    }

    public static List<String> getDijkstraShortestPath(String startStation, String endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }
}
