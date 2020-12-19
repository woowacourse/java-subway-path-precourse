package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Distances {
	private final List<Integer> distances = new ArrayList<>();

	public static void addDistance(String lineName, Integer distance, int location) {
		LineRepository.getLine(lineName)
				.getDistances()
				.distances
				.add(location, distance); // index = user's input location - 1
	}
}
