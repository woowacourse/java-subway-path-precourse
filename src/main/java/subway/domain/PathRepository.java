package subway.domain;

import java.util.ArrayList;
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

	public static int findMinuteByStationNames(List<String> stationNames) {
		int totalMinute = 0;
		for (int i = 0; i < stationNames.size() - 1; i++) {
			totalMinute += findMinuteByStationName(stationNames.get(i), stationNames.get(i + 1));
		}
		return totalMinute;
	}

	public static int findDistanceByStationNames(List<String> stationNames) {
		int totalDistance = 0;
		for (int i = 0; i < stationNames.size() - 1; i++) {
			totalDistance += findDistanceByStationName(stationNames.get(i), stationNames.get(i + 1));
		}
		return totalDistance;
	}
}
