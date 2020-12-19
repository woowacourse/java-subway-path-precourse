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
	private static final String[][] DEFAULT_SECTION = { { "교대역", "강남역", "3" }, { "강남역", "역삼역", "3" },
			{ "교대역", "남부터미널역", "2" }, { "남부터미널", "양재역", "1" }, { "앙재역", "매봉역", "1" }, { "강남역", "양재역", "8" },
			{ "양재역", "양재시민의숲역", "3" } };

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO: 프로그램 구현

		startProgram(scanner);
	}

	static public void startProgram(Scanner scanner) {
		StationRepository stationRepositiory = new StationRepository();
		LineRepository lineRepositiory = new LineRepository();
		//SubwaySection subwaySection = new SubwaySection();
		
		defaultStation(stationRepositiory);
		defaultLine(lineRepositiory);
		//defaultSection(subwaySection);
		
		stationRepositiory.viewStations();
		lineRepositiory.viewLineRepository();
		
		//subwaySection.viewSection();
	}

	private static void defaultStation(StationRepository stationRepositiory) {
		for (int stationCount = 0; stationCount < DEFAULT_STATIONS.length; stationCount++) {
			Station station = new Station(DEFAULT_STATIONS[stationCount]);
			stationRepositiory.addStation(station);
			//subwaySection.addSection(station.getName());
		}
	}

	private static void defaultLine(LineRepository lineRepositiory) {
		for (int lineCount = 0; lineCount < DEFAULT_LINES.length; lineCount++) {
			Line line = new Line(DEFAULT_STATIONS[lineCount]);
			lineRepositiory.addLine(line);
		}
	}

	private static void defaultSection(SubwaySection subwaySection) {
		for (int sectionCount = 0; sectionCount < DEFAULT_LINES.length; sectionCount++) {
			//subwaySection.sectionVertex(DEFAULT_SECTION[sectionCount][0], DEFAULT_SECTION[sectionCount][1], Integer.parseInt(DEFAULT_SECTION[sectionCount][2]));
		}
	}
}
