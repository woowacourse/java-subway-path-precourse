package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.List;

public class Settings {
    public static final List<String> INIT_STATIONS = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final String INIT_LINE1_NAME = "2호선";
    private static final String INIT_LINE2_NAME = "3호선";
    private static final String INIT_LINE3_NAME = "신분당선";

    public static void init() {
        initStations();
        initLines();
    }

    private static void initStations() {
        for (String stationName : INIT_STATIONS) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private static void initLines() {
        initLine1();
        initLine2();
        initLine3();
    }

    private static void initLine1 () {
        Station s1 = StationRepository.getStation("교대역");
        Station s2 = StationRepository.getStation("강남역");
        Station s3 = StationRepository.getStation("역삼역");
        Edge e1 = new Edge(s1,s2,2,3);
        Edge e2 = new Edge(s2,s3,2,3);
        LineRepository.addLine(new Line(INIT_LINE1_NAME, Arrays.asList(e1,e2)));
    }

    private static void initLine2 () {
        Station s1 = StationRepository.getStation("교대역");
        Station s2 = StationRepository.getStation("남부터미널역");
        Station s3 = StationRepository.getStation("양재역");
        Station s4 = StationRepository.getStation("매봉역");
        Edge e1 = new Edge(s1,s2,3,2);
        Edge e2 = new Edge(s2,s3,6,5);
        Edge e3 = new Edge(s3,s4,1,1);
        LineRepository.addLine(new Line(INIT_LINE2_NAME, Arrays.asList(e1,e2,e3)));
    }

    private static void initLine3 () {
        Station s1 = StationRepository.getStation("강남역");
        Station s2 = StationRepository.getStation("양재역");
        Station s3 = StationRepository.getStation("양재시민의숲역");
        Edge e1 = new Edge(s1,s2,2,8);
        Edge e2 = new Edge(s2,s3,10,3);
        LineRepository.addLine(new Line(INIT_LINE3_NAME, Arrays.asList(e1,e2)));
    }
}
