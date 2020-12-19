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
			for (int i = 0; i < line.get_distances().size(); i++) {
				graph.setEdgeWeight(graph.addEdge(line.get_stations().get(i), line.get_stations().get(i + 1)),
						line.get_distances().get(i));
			}
		}
	}

	static void setEdge2timeGragh() {
		for (Line line : LineRepository.lines()) {
			for (int i = 0; i < line.get_times().size(); i++) {
				graph.setEdgeWeight(graph.addEdge(line.get_stations().get(i), line.get_stations().get(i + 1)),
						line.get_times().get(i));
			}
		}
	}

	public static void initDistanceGraph() {
		station2Vertex();
		setEdge2distanceGragh();

	}

	public static void initTimeGraph() {
		station2Vertex();
		setEdge2timeGragh();

	}

	public static boolean check_isSame_from_to(String from, String to) {
		return from.equals(to);
	}

	public static void shortestPathByDistance(String from, String to) {
		initDistanceGraph();
		System.out.println("\n## 조회 결과\n[INFO] ---");
		DijkstraShortestPath<Station, Integer> dijkstraShortestPath = new DijkstraShortestPath(graph);
		List<Station> shortestPath = dijkstraShortestPath
				.getPath(StationRepository.getStationByName(from), StationRepository.getStationByName(to))
				.getVertexList();
		System.out.println("[INFO] 총 거리: " + (int) dijkstraShortestPath
				.getPath(StationRepository.getStationByName(from), StationRepository.getStationByName(to)).getWeight()
				+ "km");
		System.out.println("[INFO] 총 소요 시간: " + "분");
		System.out.println("[INFO] ---");
		for (Station station : shortestPath) {
			System.out.println("[INFO] " + station.getName());
		}
	}

	public static void shortestPathByTime(String from, String to) {
		initTimeGraph();
		System.out.println("\n## 조회 결과\n[INFO] ---");

		DijkstraShortestPath<Station, Integer> dijkstraShortestPath = new DijkstraShortestPath(graph);
		List<Station> shortestPath = dijkstraShortestPath
				.getPath(StationRepository.getStationByName(from), StationRepository.getStationByName(to))
				.getVertexList();
		System.out.println("[INFO] 총 거리: " + "km");
		System.out.println("[INFO] 총 소요 시간: " + (int) dijkstraShortestPath
				.getPath(StationRepository.getStationByName(from), StationRepository.getStationByName(to)).getWeight()
				+ "분");
		System.out.println("[INFO] ---");
		for (Station station : shortestPath) {
			System.out.println("[INFO] " + station.getName());
		}
	}

}
