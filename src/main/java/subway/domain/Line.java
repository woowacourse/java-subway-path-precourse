package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private String name;
	private int distance;
	private int time;
	private List<String> section = new ArrayList<String>();

	public Line(String name,int stationIndex, String stationName, int time, int distance) {
		this.name = name;
		addSection(stationIndex, stationName);
	}

	public String getName() {
		return name;
	}


	public void addSection(int index, String stationName) {
		section.add(index, stationName);
	}
	
	public List<String> getSection(){
		return section;
	}
}
