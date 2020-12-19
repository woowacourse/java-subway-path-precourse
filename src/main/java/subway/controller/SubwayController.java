package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Edge;
import subway.domain.EdgeRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class SubwayController {
    private WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;
    private WeightedMultigraph<String, DefaultWeightedEdge> timeGraph;

    public void initPrimary() {
        Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역")
                .forEach(name -> StationRepository.addStation(new Station(name)));
        EdgeRepository.addEdge(new Edge("교대역", "강남역", 2, 3));
        EdgeRepository.addEdge(new Edge("강남역", "역삼역", 2, 3));
        EdgeRepository.addEdge(new Edge("교대역", "남부터미널역", 3, 2));
        EdgeRepository.addEdge(new Edge("남부터미널역", "양재역", 6, 5));
        EdgeRepository.addEdge(new Edge("양재역", "매봉역", 1, 1));
        EdgeRepository.addEdge(new Edge("강남역", "양재역", 2, 8));
        EdgeRepository.addEdge(new Edge("양재역", "양재시민의숲역", 10, 3));
    }

    public void initGraph() {
        initDistanceGraph();
        initTimeGraph();
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

    public List<String> getShortestPathDistance(String from, String to) {
        return getShortestPath(from, to, this.distanceGraph);
    }
    
    public List<String> getShortestPathTime(String from, String to) {
        return getShortestPath(from, to, this.timeGraph);
    }

    private List<String> getShortestPath(String from, String to, WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(from, to).getVertexList();
    }
}
