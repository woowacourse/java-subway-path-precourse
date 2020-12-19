package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Sections {
	public static final int FIRST_SECTION_LOCATION = 0;

	private final List<Station> sections = new ArrayList<>();

	public static void addSection(String lineName, String stationName, int location) {
		LineRepository.getLine(lineName)
				.getSections()
				.sections
				.add(location - 1, StationRepository.getStation(stationName)); // index = user's input location - 1
	}
}
