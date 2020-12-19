package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private String name;
	private List<Station> stations = new ArrayList<Station>();
	private List<Integer> distances = new ArrayList<>();
	private List<Integer> times = new ArrayList<>();

	public Line(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 추가 기능 구현

	public Line(String name, List<String> station_name, int[] distances, int[] times) {
		this.name = name;
		for (String station : station_name) {
			stations.add(get_station_by_name(station));
		}
		for (int i = 0; i < distances.length; i++) {
			this.distances.add(distances[i]);
			this.times.add(times[i]);
		}

	}

	public List<Station> get_stations() {
		return stations;
	}

	public List<Integer> get_distances() {
		return distances;
	}

	public List<Integer> get_times() {
		return times;
	}

	public static Station get_station_by_name(String name) {
		for (Station station : StationRepository.stations()) {
			if (name.equals(station.getName())) {
				return station;
			}
		}
		return null;
	}
}
