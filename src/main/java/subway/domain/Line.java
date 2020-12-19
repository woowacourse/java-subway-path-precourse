package subway.domain;

import static subway.domain.StationRepository.getStationByName;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private final List<Station> stations = new ArrayList<>();
	private final String name;

	public Line(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addStation(String stationName) {
		stations.add(getStationByName(stationName));
	}
}
