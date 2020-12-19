package subway.domain;

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
}
