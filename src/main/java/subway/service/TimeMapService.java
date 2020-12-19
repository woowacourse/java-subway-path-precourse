package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.repository.TimeMapRepository;

import java.util.List;

public class TimeMapService {
    public static double getShortestTime(String origin, String destination) {
        WeightedMultigraph<String, DefaultWeightedEdge> timeMap
                = TimeMapRepository.timeMap();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeMap);

        return dijkstraShortestPath.getPath(origin, destination).getWeight();
    }

    public static List<String> getShortestTimeStations(String origin, String destination) {
        WeightedMultigraph<String, DefaultWeightedEdge> timeMap
                = TimeMapRepository.timeMap();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeMap);

        return dijkstraShortestPath.getPath(origin, destination).getVertexList();
    }
}
