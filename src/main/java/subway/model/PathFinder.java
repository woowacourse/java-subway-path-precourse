package subway.model;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.model.domain.DistanceRepository;
import subway.model.domain.TimeRepository;

import java.util.List;

public class PathFinder {
    public static List<String> getShortestPathByDistance(String from, String to) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = DistanceRepository.distanceGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(from, to).getVertexList();
        shortestPath = shortestPath;
        return shortestPath;
    }

    public static List<String> getShortestPathByTime(String from, String to) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = TimeRepository.timeGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(from, to).getVertexList();
        return shortestPath;
    }

    public static int getTotalDistance(List<String> shortestPath) {
        double totalDistance = 0;
        for (int i=0; i<shortestPath.size()-1; i++) {
            totalDistance += DistanceRepository.getWeight(shortestPath.get(i), shortestPath.get(i + 1));
        }
        return (int) totalDistance;
    }

    public static int getTotalTime(List<String> shortestPath) {
        double totalTime = 0;
        for (int i=0; i<shortestPath.size()-1; i++) {
            totalTime += TimeRepository.getWeight(shortestPath.get(i), shortestPath.get(i + 1));
        }
        return (int) totalTime;
    }
}
