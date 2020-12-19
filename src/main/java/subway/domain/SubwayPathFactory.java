package subway.domain;

import static subway.domain.LineStationRepository.*;
import static subway.domain.StationRepository.findStationByName;

public class SubwayPathFactory {
    private static String[] startStations = {"교대역", "강남역", "강남역", "역삼역", "교대역", "남부터미널역", "남부터미널역", "양재역",
            "양재역", "매봉역", "강남역", "양재역", "양재역", "양재시민의숲역"};
    private static String[] endStations = {"강남역", "교대역", "역삼역", "강남역", "남부터미널역", "교대역", "양재역", "남부터미널역",
            "매봉역", "양재역", "양재역", "강남역", "양재시민의숲역", "양재역"};
    private static int[] distances = {2, 2, 2, 2, 3, 3, 6, 6, 1, 1, 1, 1, 10, 10};
    private static int[] times = {3, 3, 3, 3, 2, 2, 5, 5, 1, 1, 8, 8, 3, 3};

    public static void init() {
        initStation();
        initLine();
        initGraphVertex();
    }

    public static void creatPathFirstGraph() {
        for (int i = 0; i < startStations.length; i++) {
            addLineStationOfSection(startStations[i], endStations[i], distances[i]);
        }
    }

    public static void creatTimeFirstGraph() {
        for (int i = 0; i < startStations.length; i++) {
            addLineStationOfSection(startStations[i], endStations[i], times[i]);
        }
    }

    private static void initStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private static void initLine() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private static void initGraphVertex() {
        addVertex("교대역");
        addVertex("강남역");
        addVertex("역삼역");
        addVertex("남부터미널역");
        addVertex("양재역");
        addVertex("양재시민의숲역");
        addVertex("매봉역");
    }
}