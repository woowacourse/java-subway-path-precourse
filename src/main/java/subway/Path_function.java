package subway;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Path_function {
	static WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
	
	static void station2Vertex() {
		for (Station station : StationRepository.stations()) {
			graph.addVertex(station);			
		}
	}
	
	static void setEdge2distanceGragh() {
		for (Line line : LineRepository.lines()) {
			for (int i=0; i < line.get_distances().size(); i++) {
				graph.setEdgeWeight(graph.addEdge(line.get_stations().get(i), line.get_stations().get(i+1)), line.get_distances().get(i));
			}
		}
	}
	
	void setEdge2timeGragh() { 
		for (Line line : LineRepository.lines()) {
			for (int i=0; i < line.get_times().size(); i++) {
				graph.setEdgeWeight(graph.addEdge(line.get_stations().get(i), line.get_stations().get(i+1)), line.get_times().get(i));
			}
		}
	}
	
	public static void initDistanceGraph() {
		station2Vertex();
		setEdge2distanceGragh();
		DijkstraShortestPath<Station, Integer> dijkstraShortestPath = new DijkstraShortestPath(graph);
		List<Station> shortestPath = dijkstraShortestPath.getPath(StationRepository.getStationByName("양재시민의숲역"), StationRepository.getStationByName("역삼역")).getVertexList();	
		
	}
	
	public static void shortestPathByDistance(String from, String to) {
		
	}
	
	public static void shortestPathByTime(String from, String to) {
		
	}
}
