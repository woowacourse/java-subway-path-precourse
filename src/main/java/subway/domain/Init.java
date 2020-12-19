package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Init {
    public static void initialize() {
        initializeStation();
        initializeLine();
    }

    public static void initializeStation() {
        List<String> names = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String name : names)
            StationRepository.addStation(new Station(name));
    }

    public static void initializeLine() {
        Line line2 = new Line("2호선");
        LineRepository.addLine(line2, Constants.line2Stations, Constants.line2Distances, Constants.line2Times);
        Line line3 = new Line("3호선");
        LineRepository.addLine(line3, Constants.line3Stations, Constants.line3Distances, Constants.line3Times);
        Line lineSinbundang = new Line("신분당선");
        LineRepository.addLine(lineSinbundang, Constants.lineSinbundangStations, Constants.lineSinbundangDistances, Constants.lineSinbundangTimes);
    }
}
