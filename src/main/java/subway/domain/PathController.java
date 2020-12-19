package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import java.util.List;

public class PathController {


    public List<String> getShortestDistancePath(String startStation, String endStation) {
        Graph<String, DefaultWeightedEdge> graph = StationRepository.getShortestDistancePath();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }

    public List<String> getShortestTimePath(String startStation, String endStation) {
        Graph<String, DefaultWeightedEdge> graph = StationRepository.getShortestTimePath();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }

}
