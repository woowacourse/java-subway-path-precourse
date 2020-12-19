package subway.util;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.Path;
import subway.domain.PathRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DijkstraUtils {

	public static WeightedMultigraph<String, DefaultWeightedEdge> getGraphByDistance() {
		WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
		for (Station station : StationRepository.stations()) {
			graph.addVertex(station.getName());
		}
		for (Path path : PathRepository.paths()) {
			String[] stations = (String[]) path.getStationNames().toArray();
			double weight = path.getDistance();
			graph.setEdgeWeight(graph.addEdge(stations[0], stations[1]), weight);
		}
		return graph;
	}

	public static WeightedMultigraph<String, DefaultWeightedEdge> getGraphByMinute() {
		WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
		for (Station station : StationRepository.stations()) {
			graph.addVertex(station.getName());
		}
		for (Path path : PathRepository.paths()) {
			String[] stations = (String[]) path.getStationNames().toArray();
			double weight = path.getMinute();
			graph.setEdgeWeight(graph.addEdge(stations[0], stations[1]), weight);
		}
		return graph;
	}

	public static List<String> getPathByMinimumDistance(String startStationName, String endStationName) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(getGraphByDistance());
		List<String> shortestPath = dijkstraShortestPath.getPath(startStationName, endStationName).getVertexList();
		return shortestPath;
	}

	public static List<String> getPathByMinimumMinute(String startStationName, String endStationName) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(getGraphByMinute());
		List<String> shortestPath = dijkstraShortestPath.getPath(startStationName, endStationName).getVertexList();
		return shortestPath;
	}
}
