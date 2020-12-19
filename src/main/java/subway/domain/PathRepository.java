package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class PathRepository {
	private static final List<Path> paths = new ArrayList<>();

	public static List<Path> paths() {
		return Collections.unmodifiableList(paths);
	}

	public static void addPath(Path path) {
		paths.add(path);
	}

	public static int findDistanceByStationName(String firstStationName, String lastStationName) {
		for (Path path : paths) {
			Set<String> pathStations = path.getStationNames();
			if (pathStations.contains(firstStationName) && pathStations.contains(firstStationName)) {
				return path.getDistance();
			}
		}
		throw new IllegalArgumentException();
	}

	public static int findMinuteByStationName(String firstStationName, String lastStationName) {
		for (Path path : paths) {
			Set<String> pathStations = path.getStationNames();
			if (pathStations.contains(firstStationName) && pathStations.contains(firstStationName)) {
				return path.getMinute();
			}
		}
		throw new IllegalArgumentException();
	}
}
