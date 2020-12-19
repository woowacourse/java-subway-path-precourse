package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayMap {
	private static final WeightedMultigraph<String, DefaultWeightedEdge> subwayMapDistance
			= new WeightedMultigraph(DefaultWeightedEdge.class);
	private static final WeightedMultigraph<String, DefaultWeightedEdge> subwayMapTime
			= new WeightedMultigraph(DefaultWeightedEdge.class);

	static {
		StationRepository.stations()
				.forEach(station -> {
					subwayMapDistance.addVertex(station.getName());
					subwayMapTime.addVertex(station.getName());
				});
		LineRepository.lines()
				.forEach(line -> {
					setSubwayDistance(line);
					setSubwayTime(line);
				});
	}

	public static void setSubwayDistance(Line line) {
		for (int i = 0; i < line.getSections().sections().size() - 1; i++) {
			subwayMapDistance.setEdgeWeight(subwayMapDistance.addEdge(line.getSections().stationNames().get(i),
					line.getSections().stationNames().get(i + 1)),
					line.getDistances().distances().get(i));
		}
	}

	public static void setSubwayTime(Line line) {
		for (int i = 0; i < line.getSections().sections().size() - 1; i++) {
			subwayMapTime.setEdgeWeight(subwayMapTime.addEdge(line.getSections().stationNames().get(i),
					line.getSections().stationNames().get(i + 1)),
					line.getTimes().times().get(i));
		}
	}

	public static List<String> getLeastDistancePath(String start, String end) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(subwayMapDistance);
		return dijkstraShortestPath.getPath(start, end).getVertexList();
	}

	public static List<String> getLeastTimePath(String start, String end) {
		DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(subwayMapTime);
		return dijkstraShortestPath.getPath(start, end).getVertexList();
	}
}
