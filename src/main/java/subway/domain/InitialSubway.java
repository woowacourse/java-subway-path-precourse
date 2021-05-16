package subway.domain;

import java.util.*;

import static subway.domain.LineRepository.addLine;
import static subway.domain.StationRepository.addStation;

//- 2호선: 교대역 - ( 2km / 3분 ) - 강남역 - ( 2km / 3분 ) - 역삼역
//- 3호선: 교대역 - ( 3km / 2분 ) - 남부터미널역 - ( 6km / 5분 ) - 양재역 - ( 1km / 1분 ) - 매봉역
//- 신분당선: 강남역 - ( 2km / 8분 ) - 양재역 - ( 10km / 3분 ) - 양재시민의숲역

public enum InitialSubway {
	LINE_2("2호선",
			Arrays.asList("교대역", "강남역", "역삼역"),
			Arrays.asList(2, 2, 0),
			Arrays.asList(3, 3, 0)),
	LINE_3("3호선",
			Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"),
			Arrays.asList(3, 6, 1, 0),
			Arrays.asList(2, 5, 1, 0)),
	LINE_SHIN_BUNDANG("신분당선",
			Arrays.asList("강남역", "양재역", "양재시민의숲역"),
			Arrays.asList(2, 10, 0),
			Arrays.asList(8, 3, 0));

	private final String lineName;
	private final List<String> sections;
	private final List<Integer> distances;
	private final List<Integer> times;

	InitialSubway(String lineName, List<String> sections, List<Integer> distances, List<Integer> times) {
		this.lineName = lineName;
		this.sections = sections;
		this.distances = distances;
		this.times = times;
	}

	public static void initializeStations() {
		Arrays.stream(values())
				.map(subway -> subway.sections)
				.flatMap(Collection::stream)
				.distinct()
				.forEach(station -> addStation(new Station(station)));
	}

	public static void initializeLines() {
		Arrays.stream(values())
				.forEach(subway -> addLine(new Line(subway.lineName)));
	}

	private static ArrayList<String> getReversedSections(InitialSubway subway) {
		ArrayList<String> stationsCopy = new ArrayList<String>(subway.sections);
		Collections.reverse(stationsCopy);
		return stationsCopy;
	}

	private static void createSections(InitialSubway subway) {
		for (String station : getReversedSections(subway)) {
			Sections.addSection(subway.lineName, station, Sections.FIRST_SECTION_LOCATION);
		}
	}

	public static void initializeSections() {
		Arrays.stream(values())
				.forEach(InitialSubway::createSections);
	}

	private static ArrayList<Integer> getReversedDistances(InitialSubway subway) {
		ArrayList<Integer> distancesCopy = new ArrayList<Integer>(subway.distances);
		Collections.reverse(distancesCopy);
		return distancesCopy;
	}

	private static void createDistances(InitialSubway subway) {
		for (Integer distance : getReversedDistances(subway)) {
			Distances.addDistance(subway.lineName, distance, Sections.FIRST_SECTION_LOCATION);
		}
	}

	public static void initializeDistances() {
		Arrays.stream(values())
				.forEach(InitialSubway::createDistances);
	}

	private static ArrayList<Integer> getReversedTimes(InitialSubway subway) {
		ArrayList<Integer> timesCopy = new ArrayList<Integer>(subway.times);
		Collections.reverse(timesCopy);
		return timesCopy;
	}

	private static void createTimes(InitialSubway subway) {
		for (Integer time : getReversedTimes(subway)) {
			Times.addTime(subway.lineName, time, Sections.FIRST_SECTION_LOCATION);
		}
	}

	public static void initializeTimes() {
		Arrays.stream(values())
				.forEach(InitialSubway::createTimes);
	}
}
