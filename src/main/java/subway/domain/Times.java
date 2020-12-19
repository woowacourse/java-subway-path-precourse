package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Times {
	private final List<Integer> times = new ArrayList<>();

	public static void addTime(String lineName, Integer time, int location) {
		LineRepository.getLine(lineName)
				.getTimes()
				.times
				.add(location, time);
	}
}
