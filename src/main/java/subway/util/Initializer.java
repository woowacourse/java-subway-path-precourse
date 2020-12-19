package subway.util;

import subway.domain.Line;
import subway.domain.Station;

import java.util.Arrays;
import java.util.List;

public class Initializer {
    private static final List<String> stations =
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> lines = Arrays.asList("2호선", "3호선", "신분당선");

    public void init() {
        createStation();
        createLine();
    }

    private void createStation() {
        stations.forEach(Station::from);
    }

    private void createLine() {
        lines.forEach(Line::from);
    }

    private void enrolllStationOnLine() {
        //findLineByName
        //findLine.addStation(station);
    }

}
