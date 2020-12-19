package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Route {
    private static WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    
    public static void initializeDistanceGraph() {
        addVertex(distanceGraph);
        addDistanceEdges();
    }
    
    public static void initializeTimeGraph() {
        addVertex(timeGraph);
        addTimeEdges();
    }
    
    public static void addVertex(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station);
        }
    }
    
    public static void addDistanceEdges() {
        for (Line line : LineRepository.lines()) {
            for (Section section : line.sections()) {
                distanceGraph.setEdgeWeight(distanceGraph.addEdge(section.getUpStation(), section.getDownStation()), section.getDistance());
            }
        }
    }
    
    public static void addTimeEdges() {
        for (Line line : LineRepository.lines()) {
            for (Section section : line.sections()) {
                timeGraph.setEdgeWeight(timeGraph.addEdge(section.getUpStation(), section.getDownStation()), section.getTime());
            }
         }
     }
    
    public static List<Station> getShortestDistanceRoute(Station departureStation, Station arrivalStation) {
        initializeDistanceGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        List<Station> shortestDistancePath = dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        return shortestDistancePath;
    }
    
    public static List<Station> getShortestTimeRoute(Station departureStation, Station arrivalStation) {
        initializeTimeGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        List<Station> shortestTimePath = dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        return shortestTimePath;
    }
}
