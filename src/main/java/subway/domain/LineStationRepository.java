package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import static subway.domain.SubwayPathFactory.creatPathFirstGraph;

public class LineStationRepository {
    private static WeightedMultigraph<String, DefaultWeightedEdge> lineStation
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static void addLineStationOfSection(String startStation, String endStation, int weight) {
        lineStation.setEdgeWeight(lineStation.addEdge(startStation, endStation), weight);
    }

    public static void addVertex(String startStation) {
        lineStation.addVertex(startStation);
    }

    public static GraphPath findShortestPath(String start, String end) {
        creatPathFirstGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(lineStation);
        return dijkstraShortestPath.getPath(start, end);
    }
}