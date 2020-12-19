package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.List;

public class PathController {


    public List getShortestDistancePath(String startStation, String endStation) {
        Graph<String, DefaultWeightedEdge> graph = StationRepository.getShortestDistancePath();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }

    public List getShortestTimePath(String startStation, String endStation) {
        Graph<String, DefaultWeightedEdge> graph = StationRepository.getShortestTimePath();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }







}
