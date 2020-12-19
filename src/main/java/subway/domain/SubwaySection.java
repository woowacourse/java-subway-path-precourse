package subway.domain;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SubwaySection {
	private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(
			DefaultWeightedEdge.class);
	private static final WeightedMultigraph<String, DefaultWeightedEdge> lengthGraph = new WeightedMultigraph(
			DefaultWeightedEdge.class);

	private static final String ERROR_INPUT_MESSAGE = "[ERROR] 잘못된 입력값 입니다.\n";

	public static void addSection(String station) {
		timeGraph.addVertex(station);
		lengthGraph.addVertex(station);
	}

	public static boolean findStation(String name) {
		if (timeGraph.containsVertex(name)) {
			return true;
		}
		return false;
	}

	public void sectionTime(String startStation, String endStation, int time) {
		if (timeGraph.containsVertex(startStation) && timeGraph.containsVertex(endStation)) {
			timeGraph.setEdgeWeight(timeGraph.addEdge(startStation, endStation), time);
			return;
		}
		System.out.println(ERROR_INPUT_MESSAGE);
	}

	public void sectionLength(String startStation, String endStation, int time) {
		if (lengthGraph.containsVertex(startStation) && lengthGraph.containsVertex(endStation)) {
			lengthGraph.setEdgeWeight(lengthGraph.addEdge(startStation, endStation), time);
			return;
		}
		System.out.println(ERROR_INPUT_MESSAGE);
	}

	public void minTimeSection(String startStation, String endStation) {
		DijkstraShortestPath dijkstraLengthShortestPath = new DijkstraShortestPath(lengthGraph);
		DijkstraShortestPath dijkstraTimeShortestPath = new DijkstraShortestPath(timeGraph);
		List<String> shortestPath = dijkstraTimeShortestPath.getPath(startStation, endStation).getVertexList();
		int tempLength = 0;
		for (int count = 0; count < shortestPath.size() - 1; count++) {
			tempLength += (int) dijkstraLengthShortestPath.getPathWeight(shortestPath.get(count),
					shortestPath.get(count + 1));
		}
		System.out.println("[INFO] ---");
		System.out.println("[INFO] 총 거리: " + tempLength + "km");
		System.out.println(
				"[INFO] 총 소요 시간: " + (int) dijkstraTimeShortestPath.getPathWeight(startStation, endStation) + "분");
		System.out.println("[INFO] ---");
		for (int i = 0; i < shortestPath.size(); i++) {
			System.out.println("[INFO] " + shortestPath.get(i));
		}
		System.out.println();
	}

	public void minLengthSection(String startStation, String endStation) {
		DijkstraShortestPath dijkstraLengthShortestPath = new DijkstraShortestPath(lengthGraph);
		DijkstraShortestPath dijkstraTimeShortestPath = new DijkstraShortestPath(timeGraph);
		List<String> shortestPath = dijkstraLengthShortestPath.getPath(startStation, endStation).getVertexList();
		int tempTime = 0;
		for (int count = 0; count < shortestPath.size() - 1; count++) {
			tempTime += (int) dijkstraTimeShortestPath.getPathWeight(shortestPath.get(count),
					shortestPath.get(count + 1));
		}
		System.out.println("[INFO] ---");
		System.out.println(
				"[INFO] 총 거리: " + (int) dijkstraLengthShortestPath.getPathWeight(startStation, endStation) + "km");
		System.out.println("[INFO] 총 소요 시간: " + tempTime + "분");

		System.out.println("[INFO] ---");
		for (int i = 0; i < shortestPath.size(); i++) {
			System.out.println("[INFO] " + shortestPath.get(i));
		}
		System.out.println();
	}
}
