package subway.config;

import subway.domain.*;

import java.util.ArrayList;
import java.util.Arrays;

public class SubwayConfig {

    public static void subwayMapInit() {
        lineInit();
        stationInit();
        subwayInit();
    }

    private static void stationInit() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private static void lineInit() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private static void subwayInit() {
        LineTwoInit();
        LineThreeInit();
        LineSinBundangInit();
    }

    private static void LineTwoInit() {
        LineStationRepository.addLineStation(new LineStation(LineRepository.findByName("2호선"),
                        new ArrayList<>(Arrays.asList(
                                StationRepository.findByName("교대역"),
                                StationRepository.findByName("강남역"),
                                StationRepository.findByName("역삼역"))
                        ),
                        new ArrayList<>(Arrays.asList(
                                "교대역,강남역,2/3",
                                "강남역,역삼역,2/3"))
                        ));
    }

    private static void LineThreeInit() {
        LineStationRepository.addLineStation(new LineStation(LineRepository.findByName("3호선"),
                        new ArrayList<>(Arrays.asList(
                                StationRepository.findByName("교대역"),
                                StationRepository.findByName("남부터미널역"),
                                StationRepository.findByName("양재역"),
                                StationRepository.findByName("매봉역"))
                        ),
                        new ArrayList<>(Arrays.asList(
                                "교대역,남부터미널역,3/2",
                                "남부터미널역,양재역,6/5",
                                "양재역,매봉역,1/1")
                        )
                )
        );
    }

    private static void LineSinBundangInit() {
        LineStationRepository.addLineStation(new LineStation(LineRepository.findByName("신분당선"),
                        new ArrayList<>(Arrays.asList(
                                StationRepository.findByName("강남역"),
                                StationRepository.findByName("양재역"),
                                StationRepository.findByName("양재시민의숲역"))
                        ),
                        new ArrayList<>(Arrays.asList(
                                "강남역,양재역,2/8",
                                "양재역,양재시민의숲역,10/3")
                        )
                )
        );
    }
}
