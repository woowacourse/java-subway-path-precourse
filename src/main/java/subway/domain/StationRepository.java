package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
	private static final String NOT_FOUND_STATION_MESSAGE = "입력한 역을 찾을 수 없습니다.";
	private static final List<Station> stations = new ArrayList<>();

	public static List<Station> stations() {
		return Collections.unmodifiableList(stations);
	}

	public static void checkExistStationByName(String name) {
		for (Station station : stations) {
			if (station.getName().equals(name)) {
				return;
			}
		}
		throw new IllegalArgumentException(NOT_FOUND_STATION_MESSAGE);
	}

	public static void addStation(Station station) {
		if (!stations.contains(station)) {
			stations.add(station);
		}
	}
}
