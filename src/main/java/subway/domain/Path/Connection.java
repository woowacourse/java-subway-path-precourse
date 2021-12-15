package subway.domain.Path;

import subway.domain.Station;

public class Connection {
	private Station[] stations;
	private final int distance;
	private final int time;


	public Connection(Station[] stations, int distance, int time) {
		this.stations = stations;
		this.distance = distance;
		this.time = time;
	}

	public Station[] getName() {
		return stations;
	}

	// 추가 기능 구현
}
