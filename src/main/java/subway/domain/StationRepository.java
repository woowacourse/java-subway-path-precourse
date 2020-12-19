package subway.domain;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
    = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
    = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
    
    public static boolean contains(String name) {
    	for (Station station: stations) {
    		if (Objects.equals(station.getName(), name)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void addSectionDistance(String vertexStart, String vertexEnd, int distance) {
    	distanceGraph.addVertex(vertexStart);
    	distanceGraph.addVertex(vertexEnd);
    	distanceGraph.setEdgeWeight(distanceGraph.addEdge(vertexStart, vertexEnd), distance);
    }
    
    public static void addSectionTime(String vertexStart, String vertexEnd, int time) {
    	timeGraph.addVertex(vertexStart);
    	timeGraph.addVertex(vertexEnd);
    	timeGraph.setEdgeWeight(timeGraph.addEdge(vertexStart, vertexEnd), time);
    }
    
    public static Double getSectionDistance(String vertexStart, String vertexEnd) {
    	DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph, vertexStart, vertexEnd);
    	return dijkstraShortestPath.getPathLength();
    }
    
    public static double getSectionTime(String vertexStart, String vertexEnd) {
    	DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph, vertexStart, vertexEnd);
    	return dijkstraShortestPath.getPathLength();
    }
    
    public static List<DefaultWeightedEdge> getSectionList(String vertexStart, String vertexEnd) {
    	List<DefaultWeightedEdge> sectionList =   DijkstraShortestPath.findPathBetween(timeGraph, vertexStart, vertexEnd);
    	return sectionList;
    }
}
