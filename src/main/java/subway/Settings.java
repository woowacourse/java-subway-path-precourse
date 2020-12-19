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
        initLine1Edges();
        initLine2Edges();
        initLine3Edges();
    }

    private static void initLine1Edges () {
        Station s1 = StationRepository.getStation("교대역");
        Station s2 = StationRepository.getStation("강남역");
        Station s3 = StationRepository.getStation("역삼역");
        Edge e1 = new Edge(s1,s2,2,3);
        Edge e2 = new Edge(s2,s3,2,3);
        addEdge(s1,s2,2,3);
        addEdge(s2,s3,2,3);
    }

    private static void initLine2Edges () {
        Station s1 = StationRepository.getStation("교대역");
        Station s2 = StationRepository.getStation("남부터미널역");
        Station s3 = StationRepository.getStation("양재역");
        Station s4 = StationRepository.getStation("매봉역");
        addEdge(s1,s2,3,2);
        addEdge(s2,s3,6,5);
        addEdge(s3,s4,1,1);
    }


    private static void initLine3Edges () {
        Station s1 = StationRepository.getStation("강남역");
        Station s2 = StationRepository.getStation("양재역");
        Station s3 = StationRepository.getStation("양재시민의숲역");
        addEdge(s1,s2,2,8);
        addEdge(s2,s3,10,3);
    }

    private static void addEdge(Station station1, Station station2, int distance, int time) {
        Edge e1 = new Edge(station1, station2,distance,time);
        Edge e2 = new Edge(station2, station1,distance,time);
        EdgeRepository.addEdge(e1);
        EdgeRepository.addEdge(e2);
    }
}
