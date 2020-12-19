package subway.domain;

import java.util.Arrays;

public class DataInitializer {

    public static void initialize() {
        initializeStations();
        initializeLines();
    }

    private static void initializeStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    private static void initializeLines() {
        LineRepository.addLine(new Line("2호선", Arrays.asList(
                StationRepository.searchByName("교대역"),
                StationRepository.searchByName("강남역"),
                StationRepository.searchByName("역삼역")
        )));
        LineRepository.addLine(new Line("3호선", Arrays.asList(
                StationRepository.searchByName("교대역"),
                StationRepository.searchByName("남부터미널역"),
                StationRepository.searchByName("양재역"),
                StationRepository.searchByName("매봉역")
        )));
        LineRepository.addLine(new Line("신분당선", Arrays.asList(
                StationRepository.searchByName("강남역"),
                StationRepository.searchByName("양재역"),
                StationRepository.searchByName("양재시민의숲역")
        )));
    }
}
