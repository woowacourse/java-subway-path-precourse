package subway;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwaySection;

public class Application {
	private static final String[] DEFAULT_STATIONS = { "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역" };
	private static final String[] DEFAULT_LINES = { "2호선", "3호선", "신분당선" };
	private static final String[][] DEFAULT_SECTION_TIME = { { "교대역", "강남역", "3" }, { "강남역", "역삼역", "3" },
			{ "교대역", "남부터미널역", "2" }, { "남부터미널역", "양재역", "5" }, { "양재역", "매봉역", "1" }, { "강남역", "양재역", "8" },
			{ "양재역", "양재시민의숲역", "3" } };
	private static final String[][] DEFAULT_SECTION_LENGHT = { { "교대역", "강남역", "2" }, { "강남역", "역삼역", "2" },
			{ "교대역", "남부터미널역", "3" }, { "남부터미널역", "양재역", "6" }, { "양재역", "매봉역", "1" }, { "강남역", "양재역", "2" },
			{ "양재역", "양재시민의숲역", "10" } };

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO: 프로그램 구현
		startProgram(scanner);
	}

	static public void startProgram(Scanner scanner) {
		StationRepository stationRepositiory = new StationRepository();
		LineRepository lineRepositiory = new LineRepository();
		SubwaySection subwaySection = new SubwaySection();

		defaultStation(stationRepositiory, subwaySection);
		defaultLine(lineRepositiory);
		defaultSection(subwaySection);

		MainManegement main = new MainManegement(scanner, subwaySection);

	}

	private static void defaultStation(StationRepository stationRepositiory, SubwaySection subwaySection) {
		for (int stationCount = 0; stationCount < DEFAULT_STATIONS.length; stationCount++) {
			Station station = new Station(DEFAULT_STATIONS[stationCount]);
			stationRepositiory.addStation(station);
			subwaySection.addSection(station.getName());
		}
	}

	private static void defaultLine(LineRepository lineRepositiory) {
		for (int lineCount = 0; lineCount < DEFAULT_LINES.length; lineCount++) {
			Line line = new Line(DEFAULT_LINES[lineCount]);
			lineRepositiory.addLine(line);
		}
	}

	private static void defaultSection(SubwaySection subwaySection) {
		for (int sectionCount = 0; sectionCount < DEFAULT_SECTION_TIME.length; sectionCount++) {
			subwaySection.sectionTime(DEFAULT_SECTION_TIME[sectionCount][0], DEFAULT_SECTION_TIME[sectionCount][1],
					Integer.parseInt(DEFAULT_SECTION_TIME[sectionCount][2]));
			subwaySection.sectionLength(DEFAULT_SECTION_LENGHT[sectionCount][0],
					DEFAULT_SECTION_LENGHT[sectionCount][1], Integer.parseInt(DEFAULT_SECTION_LENGHT[sectionCount][2]));
		}
	}
}
