package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.Arrays;
import java.util.List;

public class Initializer {

    private static final String station1 = "교대역";
    private static final String station2 = "강남역";
    private static final String station3 = "역삼역";
    private static final String station4 = "남부터미널역";
    private static final String station5 = "양재역";
    private static final String station6 = "양재시민의숲역";
    private static final String station7 = "매봉역";

    private static final String line1 = "2호선";
    private static final String line2 = "3호선";
    private static final String line3 = "신분당선";

    private static final List<String> initStations = Arrays
        .asList(station1, station2, station3, station4, station5, station6, station7);
    private static final List<String> initLines = Arrays
        .asList(line1, line2, line3);

    private Initializer() {
    }

    public static void set() {
        makeStations();
        makeLines();
    }

    private static void makeStations() {
        for (String stationName : initStations) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    private static void makeLines() {
        for (String lineName : initLines) {
            Line line = new Line(lineName);
            LineRepository.addLine(line);
        }
    }
}
