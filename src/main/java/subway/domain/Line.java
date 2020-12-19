package subway.domain;

import static subway.domain.StationRepository.getStationByName;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Line {
	private final List<Station> stations = new ArrayList<>();
	private final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(
		DefaultWeightedEdge.class);
	private final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(
		DefaultWeightedEdge.class);
	private final String name;

	public Line(String name) {
		this.name = name;
	}

	public Line(String name, String upwardTerminalName) {
		this.name = name;
		stations.add(getStationByName(upwardTerminalName));
		timeGraph.addVertex(upwardTerminalName);
		distanceGraph.addVertex(upwardTerminalName);
	}

	public String getName() {
		return name;
	}

	public void addNextStation(String beforeStationName, String newStationName, int distanceWeight,
		int timeWeight) {
		stations.add(getStationByName(newStationName));

		distanceGraph.addVertex(newStationName);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(beforeStationName, newStationName),
			distanceWeight);
		timeGraph.addVertex(newStationName);
		timeGraph.setEdgeWeight(timeGraph.addEdge(beforeStationName, newStationName), timeWeight);
	}
}
