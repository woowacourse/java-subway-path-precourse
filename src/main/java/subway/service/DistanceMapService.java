package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.repository.DistanceMapRepository;

import java.util.List;

public class DistanceMapService {
    public static double getShortestDistance(String origin, String destination) {
        WeightedMultigraph<String, DefaultWeightedEdge> distanceMap
                = DistanceMapRepository.distanceMap();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceMap);

        return dijkstraShortestPath.getPath(origin, destination).getWeight();
    }

    public static List<String> getShortestDistanceStations(String origin, String destination) {
        WeightedMultigraph<String, DefaultWeightedEdge> distanceMap
                = DistanceMapRepository.distanceMap();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceMap);

        return dijkstraShortestPath.getPath(origin, destination).getVertexList();
    }
}
