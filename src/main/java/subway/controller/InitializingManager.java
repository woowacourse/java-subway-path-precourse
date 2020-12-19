package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitializingManager {
    private static final String[] defaultStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String[] defaultLines = {"2호선", "3호선", "신분당선"};
    private static final String[][] defaultInLineStations = {{"교대역", "강남역", "역삼역"}, {"교대역", "남부터미널역", "양재역", "매봉역"}, {"강남역", "양재역", "양재시민의숲역"}};

    private static final int[][] defaultLineDistance = {{2, 2}, {3, 6, 1}, {2, 10}};
    private static final int[][] defaultLineTime = {{3, 3}, {2, 5, 1}, {8, 3}};

    public static void initialize() {
        initiateStation();
        initiateLine();
        initiateInterval();
    }

    private static void initiateStation() {
        for (String station : defaultStations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private static void initiateLine() {
        for (int i = 0; i < defaultLines.length; i++) {
            LineRepository.addLine(
                    new Line(defaultLines[i], defaultInLineStations[i], defaultLineDistance[i], defaultLineTime[i]));
        }
    }

    private static void initiateInterval() {
        for (Line line : LineRepository.lines()) {
            line.registerInterval();
        }
    }

}
