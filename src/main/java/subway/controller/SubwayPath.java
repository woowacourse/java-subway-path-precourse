package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.EdgeRepository;
import subway.domain.StationRepository;

import java.util.List;

public class SubwayPath {
    private WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;
    private WeightedMultigraph<String, DefaultWeightedEdge> timeGraph;

    public void initGraph() {
        initDistanceGraph();
        initTimeGraph();
    }

    public List<String> getShortestPathDistance(String from, String to) {
        return getShortestPath(from, to, this.distanceGraph);
    }

    public double getShortestPathDistanceWeight(String from, String to) {
        return getShortestPathWeight(from, to, this.distanceGraph);
    }

    public List<String> getShortestPathTime(String from, String to) {
        return getShortestPath(from, to, this.timeGraph);
    }

    public double getShortestPathTimeWeight(String from, String to) {
        return getShortestPathWeight(from, to, this.timeGraph);
    }

    private void initDistanceGraph() {
        this.distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        StationRepository.stations().forEach(station -> distanceGraph.addVertex(station.getName()));
        EdgeRepository.edges().forEach(edge -> distanceGraph.setEdgeWeight(distanceGraph.addEdge(edge.getFrom(), edge.getTo()), edge.getDistance()));
    }

    private void initTimeGraph() {
        this.timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        StationRepository.stations().forEach(station -> timeGraph.addVertex(station.getName()));
        EdgeRepository.edges().forEach(edge -> timeGraph.setEdgeWeight(timeGraph.addEdge(edge.getFrom(), edge.getTo()), edge.getTime()));
    }

    private List<String> getShortestPath(String from, String to, WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(from, to).getVertexList();
    }

    private double getShortestPathWeight(String from, String to, WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPathWeight(from, to);
    }
}
