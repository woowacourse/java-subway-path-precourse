package subway.domain;

public class PathBuilder {
	private Station firstStation;
	private Station lastStation;
	private int distance;
	private int minute;

	public PathBuilder firstStation(String stationName) {
		this.firstStation = StationRepository.getStationByName(stationName);
		return this;
	}

	public PathBuilder lastStation(String stationName) {
		this.lastStation = StationRepository.getStationByName(stationName);
		return this;
	}

	public PathBuilder distance(int distance) {
		this.distance = distance;
		return this;
	}

	public PathBuilder minute(int minute) {
		this.minute = minute;
		return this;
	}

	public Path build() {
		return new Path(firstStation, lastStation, distance, minute);
	}
}
