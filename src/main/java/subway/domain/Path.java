package subway.domain;

public class Path {
	private Station firstStation;
	private Station lastStation;
	private int distance;
	private int minute;

	public Path(Station firstStation, Station lastStation, int distance, int minute) {
		super();
		this.firstStation = firstStation;
		this.lastStation = lastStation;
		this.distance = distance;
		this.minute = minute;
	}

	public Station getFirstStation() {
		return firstStation;
	}

	public Station getLastStation() {
		return lastStation;
	}

	public int getDistance() {
		return distance;
	}

	public int getMinute() {
		return minute;
	}
}
