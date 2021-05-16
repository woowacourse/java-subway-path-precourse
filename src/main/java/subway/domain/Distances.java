package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Distances {
	private final List<Integer> distances = new ArrayList<>();

	public static void addDistance(String lineName, Integer distance, int location) {
		LineRepository.getLine(lineName)
				.getDistances()
				.distances
				.add(location, distance);
	}

	public List<Integer> distances() {
		return Collections.unmodifiableList(distances);
	}
}
