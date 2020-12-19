package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.*;

public class InitialSetter {
    private static final List<String> STATION_NAME_LIST = Collections.unmodifiableList(
        Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역"));
    private static final List<String> LINE_NAME_LIST =
            Collections.unmodifiableList(Arrays.asList("2호선", "3호선", "신분당선"));

    private InitialSetter() {
    }

    public static void setupInitialInfo() {
        setupStation();
        setupLine();
        setUpPath();
    }

    private static void setupStation() {
        for (String stationName : STATION_NAME_LIST) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    private static void setupLine() {
        for (String lineName : LINE_NAME_LIST) {
            Line line = new Line(lineName);
            LineRepository.addLine(line);
        }
    }

    private static void setUpPath(){

    }

}
