package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Init {
    public static final List<String> line2Stations = Arrays.asList("교대역", "강남역", "역삼역");
    public static final List<Integer> line2Distances = Arrays.asList(2, 2);
    public static final List<Integer> line2Times = Arrays.asList(3, 3);
    public static final List<String> line3Stations = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
    public static final List<Integer> line3Distances = Arrays.asList(3, 6, 1);
    public static final List<Integer> line3Times = Arrays.asList(2, 5, 1);
    public static final List<String> lineSinbundangStations = Arrays.asList("강남역", "양재역", "양재시민의숲역");
    public static final List<Integer> lineSinbundangDistances = Arrays.asList(2, 10);
    public static final List<Integer> lineSinbundangTimes = Arrays.asList(8, 3);

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
        LineRepository.addLine(line2, line2Stations, line2Distances, line2Times);
        Line line3 = new Line("3호선");
        LineRepository.addLine(line3, line3Stations, line3Distances, line3Times);
        Line lineSinbundang = new Line("신분당선");
        LineRepository.addLine(lineSinbundang, lineSinbundangStations, lineSinbundangDistances, lineSinbundangTimes);
    }
}
