package subway.domain;

import java.util.LinkedList;

public class Line {
	private String name;
	private LinkedList<Path> paths;

	public String getName() {
		return name;
	}

	public LinkedList<Path> getPaths() {
		return paths;
	}

	public void addPath(Path path) {
		paths.add(path);
	}
}
