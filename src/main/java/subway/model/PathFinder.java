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
        return shortestPath;
    }

    public static List<String> getShortestPathByTime(String from, String to) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = TimeRepository.timeGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(from, to).getVertexList();
        return shortestPath;
    }

    public static double getTotalDistance() {
        return 0;
    }

    public static double getTotalTime() {
        return 0;
    }
}
