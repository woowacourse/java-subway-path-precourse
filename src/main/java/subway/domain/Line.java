package subway.domain;

public class Line {
	private final Sections sections = new Sections();
	private final Distances distances = new Distances();
	private final Times times = new Times();
	private String name;

	public Line(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 추가 기능 구현
	public Sections getSections() {
		return sections;
	}

	public Distances getDistances() {
		return distances;
	}

	public Times getTimes() {
		return times;
	}
}
