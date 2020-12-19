package subway.controller;

import java.util.Arrays;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Subway {

    private static final String[] initStations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역",
        "매봉역"};
    private static final String[] initLines = {"2호선", "3호선", "신분당선"};


    public void run() {
        init();
    }

    private void init() {
        Station station0 = new Station(initStations[0]);
        Station station1 = new Station(initStations[1]);
        Station station2 = new Station(initStations[2]);
        Station station3 = new Station(initStations[3]);
        Station station4 = new Station(initStations[4]);
        Station station5 = new Station(initStations[5]);
        Station station6 = new Station(initStations[6]);
        StationRepository.addAll(
            Arrays.asList(station0, station1, station2, station3, station4, station5, station6));

        Line line0 = new Line(initLines[0]);
        Line line1 = new Line(initLines[1]);
        Line line2 = new Line(initLines[2]);
        line0.addSection(station0, station1, 2, 3);
        line0.addSection(station1, station2, 2, 3);
        line0.addSection(station2, null, 0, 0);

        line1.addSection(station0, station3, 3, 2);
        line1.addSection(station3, station4, 6, 5);
        line1.addSection(station4, station6, 1, 1);
        line1.addSection(station6, null, 0, 0);

        line2.addSection(station1, station2, 2, 8);
        line2.addSection(station2, station5, 10, 3);
        line2.addSection(station5, null, 0, 0);

        LineRepository.addAll(Arrays.asList(line0, line1, line2));
    }
}
