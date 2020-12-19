package subway;

import static subway.domain.LineRepository.addLine;
import static subway.domain.StationRepository.addStation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class Setting {
	private final static List<String> INIT_STATIONS_NAME = new ArrayList<>(
		Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));

	public static void initSetting() {
		setInitStations();
		setInit2ndLine();
		setInit3rdLine();
		setInitSinbundangLine();
	}

	private static void setInitStations() {
		for (String stationName : INIT_STATIONS_NAME) {
			addStation(new Station(stationName));
		}
	}

	private static void setInit2ndLine() {
		Line line = new Line("2호선", "교대역");
		addLine(line);

		line.addNextStation("교대역", "강남역", 2, 3);
		line.addNextStation("강남역", "역삼역", 2, 3);
	}

	private static void setInit3rdLine() {
		Line line = new Line("3호선", "교대역");
		addLine(line);

		line.addNextStation("교대역", "남부터미널역", 3, 2);
		line.addNextStation("남부터미널역", "양재역", 6, 5);
		line.addNextStation("양재역", "매봉역", 1, 1);
	}

	private static void setInitSinbundangLine() {
		Line line = new Line("신분당", "강남역");
		addLine(line);

		line.addNextStation("강남역", "양재역", 2, 8);
		line.addNextStation("양재역", "양재시민의숲역", 10, 3);
	}
}
