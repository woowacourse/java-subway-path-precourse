package subway;

import static subway.domain.Graph.addDistanceEdge;
import static subway.domain.Graph.addTimeEdge;
import static subway.domain.Graph.addVertex;
import static subway.domain.LineRepository.addLine;
import static subway.domain.StationRepository.addStation;
import static subway.domain.StationRepository.getStationByName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class Setting {
	private final static List<String> INIT_STATIONS_NAME = new ArrayList<>(
		Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
	private final static List<String> INIT_2ND_LINE_STATIONS = new ArrayList<>(
		Arrays.asList("교대역", "강남역", "역삼역"));
	private final static List<String> INIT_3RD_LINE_STATIONS = new ArrayList<>(
		Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
	private final static List<String> INIT_SINBUNDANG_LINE_STATIONS = new ArrayList<>(
		Arrays.asList("강남역", "양재역", "양재시민의숲역"));

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
		Line line = new Line("2호선");
		addLine(line);
		for (String stationName : INIT_2ND_LINE_STATIONS) {
			if (getStationByName(stationName) != null) {
				line.addStation(stationName);
				addVertex(stationName);
			}
		}
		addTimeEdge("교대역", "강남역", 3);
		addTimeEdge("강남역", "역삼역", 3);
		addDistanceEdge("교대역", "강남역", 2);
		addDistanceEdge("강남역", "역삼역", 2);
	}

	private static void setInit3rdLine() {
		Line line = new Line("3호선");
		addLine(line);
		for (String stationName : INIT_3RD_LINE_STATIONS) {
			if (getStationByName(stationName) != null) {
				line.addStation(stationName);
				addVertex(stationName);
			}
		}
		addTimeEdge("교대역", "남부터미널역", 2);
		addTimeEdge("남부터미널역", "양재역", 5);
		addTimeEdge("양재역", "매봉역", 1);
		addDistanceEdge("교대역", "남부터미널역", 3);
		addDistanceEdge("남부터미널역", "양재역", 6);
		addDistanceEdge("양재역", "매봉역", 1);
	}

	private static void setInitSinbundangLine() {
		Line line = new Line("신분당");
		addLine(line);
		for (String stationName : INIT_SINBUNDANG_LINE_STATIONS) {
			if (getStationByName(stationName) != null) {
				line.addStation(stationName);
				addVertex(stationName);
			}
		}
		addTimeEdge("강남역", "양재역", 8);
		addTimeEdge("양재역", "양재시민의숲역", 3);
		addDistanceEdge("강남역", "양재역", 2);
		addDistanceEdge("양재역", "양재시민의숲역", 10);
	}
}
