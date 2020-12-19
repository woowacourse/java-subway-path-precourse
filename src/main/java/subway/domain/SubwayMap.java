package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class SubwayMap {
	static WeightedMultigraph<Station, DefaultWeightedEdge> pathWithDistance
		= new WeightedMultigraph(DefaultWeightedEdge.class);
	static WeightedMultigraph<Station, DefaultWeightedEdge> pathWithTime
		= new WeightedMultigraph(DefaultWeightedEdge.class);
	
	public static WeightedMultigraph<Station, DefaultWeightedEdge> getDistanceMap() {
		return pathWithDistance;
	}
	
	public static WeightedMultigraph<Station, DefaultWeightedEdge> getTimeMap() {
		return pathWithTime;
	}
	
	public static void makePathWithDistance(Station fromStation, Station toStation, int distance) {
		pathWithDistance.addVertex(fromStation);
		pathWithDistance.addVertex(toStation);
		pathWithDistance.setEdgeWeight(pathWithDistance.addEdge(fromStation, toStation), distance);
	}
	
	public static void makePathWithTime(Station fromStation, Station toStation, int time) {
		pathWithTime.addVertex(fromStation);
		pathWithTime.addVertex(toStation);
		pathWithTime.setEdgeWeight(pathWithTime.addEdge(fromStation, toStation), time);
	}
}
