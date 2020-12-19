package subway.util;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.Path;
import subway.domain.PathRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DijkstraUtils {
	private static final int FIRST = 0;
	private static final int LAST = 1;

	public static WeightedMultigraph<String, DefaultWeightedEdge> getGraphByDistance() {
		WeightedMultigraph<String, DefaultWeightedEdge> graph = 
				new WeightedMultigraph(DefaultWeightedEdge.class);
		for (Station station : StationRepository.stations()) {
			graph.addVertex(station.getName());
		}
		for (Path path : PathRepository.paths()) {
			List<String> stations = new ArrayList<>(path.getStationNames());
			double weight = path.getDistance();
			graph.setEdgeWeight(
					graph.addEdge(stations.get(FIRST), stations.get(LAST)), 
					weight);
		}
		return graph;
	}

	public static WeightedMultigraph<String, DefaultWeightedEdge> getGraphByMinute() {
		WeightedMultigraph<String, DefaultWeightedEdge> graph = 
				new WeightedMultigraph(DefaultWeightedEdge.class);
		for (Station station : StationRepository.stations()) {
			graph.addVertex(station.getName());
		}
		for (Path path : PathRepository.paths()) {
			List<String> stations = new ArrayList<>(path.getStationNames());
			double weight = path.getMinute();
			graph.setEdgeWeight(
					graph.addEdge(stations.get(FIRST), stations.get(LAST)), 
					weight);
		}
		return graph;
	}

	public static List<String> getPathByMinimumDistance(String startStationName, String endStationName) {
		DijkstraShortestPath dijkstraShortestPath = 
				new DijkstraShortestPath(getGraphByDistance());
		List<String> shortestPath = 
				dijkstraShortestPath
				.getPath(startStationName, endStationName)
				.getVertexList();
		return shortestPath;
	}

	public static List<String> getPathByMinimumMinute(String startStationName, String endStationName) {
		DijkstraShortestPath dijkstraShortestPath = 
				new DijkstraShortestPath(getGraphByMinute());
		List<String> shortestPath = dijkstraShortestPath
				.getPath(startStationName, endStationName)
				.getVertexList();
		return shortestPath;
	}
}
