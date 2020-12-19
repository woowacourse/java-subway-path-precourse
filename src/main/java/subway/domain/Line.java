package subway.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Line {
	private String name;
	private LinkedList<Path> paths;

	public Line(String name) {
		paths = new LinkedList<Path>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public LinkedList<Path> getPaths() {
		return paths;
	}

	public void addPath(Path path) {
		paths.add(path);
	}

	public List<String> getAllStationNames() {
		List<String> stations = new ArrayList<String>();
		for (Path path : paths) {
			for (String stationName : path.getStationNames()) {
				stations.add(stationName);
			}
		}
		return stations;
	}
}
