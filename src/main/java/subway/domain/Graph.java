package subway.domain;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Graph {
	public final static WeightedMultigraph<String, DefaultWeightedEdge> TIME_GRAPH = new WeightedMultigraph(
		DefaultWeightedEdge.class);
	public final static WeightedMultigraph<String, DefaultWeightedEdge> DISTANCE_GRAPH = new WeightedMultigraph(
		DefaultWeightedEdge.class);

	public static void addVertex(String stationName) {
		TIME_GRAPH.addVertex(stationName);
		DISTANCE_GRAPH.addVertex(stationName);
	}

	public static void addTimeEdge(String firstStationName, String secondStationName, int timeWeight) {
		TIME_GRAPH.setEdgeWeight(TIME_GRAPH.addEdge(firstStationName, secondStationName), timeWeight);
	}

	public static void addDistanceEdge(String firstStationName, String secondStationName, int distanceWeight) {
		DISTANCE_GRAPH.setEdgeWeight(DISTANCE_GRAPH.addEdge(firstStationName, secondStationName), distanceWeight);
	}

	public static int getTimeByVertexList(List<String> stringVertexList) {
		int totalTime = 0;
		int end_index = stringVertexList.size()-1;
		for (int index = 0; index < end_index; index++) {
			totalTime += (int) TIME_GRAPH.getEdgeWeight(
				TIME_GRAPH.getEdge(stringVertexList.get(index), stringVertexList.get(index+1)));
		}
		return totalTime;
	}

	public static int getDistanceByVertexList(List<String> stringVertexList) {
		int totalDistance = 0;
		int end_index = stringVertexList.size()-1;
		for (int index = 0; index < end_index; index++) {
			totalDistance += (int) DISTANCE_GRAPH.getEdgeWeight(
				DISTANCE_GRAPH.getEdge(stringVertexList.get(index), stringVertexList.get(index+1)));
		}
		return totalDistance;
	}
}
