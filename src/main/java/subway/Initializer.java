package subway;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Initializer {
	private static final List<String> SECOND_LINE = Arrays.asList("교대역", "강남역", "역삼역");
	
	private static final List<String> THIRD_LINE = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
	
	private static final List<String> SINBUNDANG_LINE = Arrays.asList("강남역", "양재역", "양재시민의숲역");
	
	private static final List<String> INITIAL_STATIONS = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
	
	private static final HashMap<String, List<String>> INITIAL_LINES = new HashMap<>() {
		{
			put("2호선", SECOND_LINE);
			put("3호선", THIRD_LINE);
			put("신분당선", SINBUNDANG_LINE);
		}
	};
	
	public static void run() {
		initStation();
		initLine();
		addSectionDistance();
		addSectionTime();
	}
	
	private static void initStation() {
		for (String name: INITIAL_STATIONS) {
			StationRepository.addStation(new Station(name));
		}
	}
	
	private static void initLine() {
		for (Entry<String, List<String>> line: INITIAL_LINES.entrySet()) {
			LineRepository.addLine(new Line(line.getKey(), line.getValue()));
		}
	}
	
	private static void addSectionDistance() {
		StationRepository.addSectionDistance("교대역", "강남역", 2);
		StationRepository.addSectionDistance("강남역", "역삼역", 2);
		StationRepository.addSectionDistance("교대역", "남부터미널역", 3);
		StationRepository.addSectionDistance("남부터미널역", "양재역", 6);
		StationRepository.addSectionDistance("양재역", "매봉역", 1);
		StationRepository.addSectionDistance("강남역", "양재역", 2);
		StationRepository.addSectionDistance("양재역", "양재시민의숲역", 10);
	}
	
	private static void addSectionTime() {
		StationRepository.addSectionTime("교대역", "강남역", 3);
		StationRepository.addSectionTime("강남역", "역삼역", 3);
		StationRepository.addSectionTime("교대역", "남부터미널역", 2);
		StationRepository.addSectionTime("남부터미널역", "양재역", 5);
		StationRepository.addSectionTime("양재역", "매봉역", 1);
		StationRepository.addSectionTime("강남역", "양재역", 8);
		StationRepository.addSectionTime("양재역", "양재시민의숲역", 3);
	}
}
