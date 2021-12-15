package subway.domain.Path;

import java.util.ArrayList;
import java.util.Arrays;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.Utils.Constants;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DistanceConnectionRepository {
	private static final WeightedMultigraph<Station, DefaultWeightedEdge> connections = new WeightedMultigraph<>(
		DefaultWeightedEdge.class);

	public static WeightedMultigraph<Station, DefaultWeightedEdge> connections() {
		return connections;
	}

	public static void addStation(Station station) {
		connections.addVertex(station);
	}

	public static void addConnection(Station station1, Station station2, int weight) {
		connections.setEdgeWeight(connections.addEdge(station1, station2), weight);
	}

	public static void addAllVertex() {
		StationRepository.stations()
			.forEach(
				DistanceConnectionRepository::addStation
			);
	}

	public static int findDistance(Station station1, Station station2) {
		for (Object[] connection : Constants.DISTANCES) {
			ArrayList stations = new ArrayList(Arrays.asList(connection));
			if (stations.contains(station1.getName()) && stations.contains(station2.getName())) {
				return (int)connection[2];
			}
		}
		return 0;
	}
}
