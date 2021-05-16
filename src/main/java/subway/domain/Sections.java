package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sections {
	public static final int FIRST_SECTION_LOCATION = 0;

	private final List<Station> sections = new ArrayList<>();

	public static void addSection(String lineName, String stationName, int location) {
		LineRepository.getLine(lineName)
				.getSections()
				.sections
				.add(location, StationRepository.getStation(stationName));
	}

	public List<Station> sections() {
		return Collections.unmodifiableList(sections);
	}

	public List<String> stationNames() {
		return sections.stream()
				.map(Station::getName)
				.collect(Collectors.toList());
	}
}
