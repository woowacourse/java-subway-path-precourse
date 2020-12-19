package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.EdgeRepository;
import subway.domain.StationRepository;

import java.util.List;

public class SubwayPath {
    public List<String> getDistancePath(String from, String to) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        StationRepository.stations().forEach(station -> graph.addVertex(station.getName()));
        EdgeRepository.edges().forEach(edge -> graph.setEdgeWeight(graph.addEdge(edge.getFrom(), edge.getTo()), edge.getDistance()));
        return new DijkstraShortestPath(graph).getPath(from, to).getVertexList();
    }

    public List<String> getTimePath(String from, String to) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        StationRepository.stations().forEach(station -> graph.addVertex(station.getName()));
        EdgeRepository.edges().forEach(edge -> graph.setEdgeWeight(graph.addEdge(edge.getFrom(), edge.getTo()), edge.getTime()));
        return new DijkstraShortestPath(graph).getPath(from, to).getVertexList();
    }
}
