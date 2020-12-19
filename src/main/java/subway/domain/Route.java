package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Route {
    private static WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    
    public static void initializeDistanceGraph() {
        addVertex();
        addDistanceEdges();
    }
    
    public static void addVertex() {
        for (Station station : StationRepository.stations()) {
            distanceGraph.addVertex(station);
        }
    }
    
    public static void addDistanceEdges() {
       for (Line line : LineRepository.lines()) {
            for (Section section : line.sections()) {
            	distanceGraph.setEdgeWeight(distanceGraph.addEdge(section.getUpStation(), section.getDownStation()), section.getDistance());
            }
        }
    }
    
    public static List<Station> getShortestDistanceRoute(Station departureStation, Station arrivalStation) {
    	initializeDistanceGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        List<Station> shortestDistancePath = dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        return shortestDistancePath;
    }
}
