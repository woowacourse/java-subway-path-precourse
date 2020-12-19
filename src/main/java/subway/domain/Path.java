package subway.domain;

import java.util.HashSet;
import java.util.Set;

public class Path {
	private Set<String> stationNames;
	private int distance;
	private int minute;

	public Path(String firstStationName, String lastStationName, int distance, int minute) {
		stationNames = new HashSet<String>();
		stationNames.add(firstStationName);
		stationNames.add(lastStationName);
		this.distance = distance;
		this.minute = minute;
	}

	public Set<String> getStationNames() {
		return stationNames;
	}

	public int getDistance() {
		return distance;
	}

	public int getMinute() {
		return minute;
	}
}
