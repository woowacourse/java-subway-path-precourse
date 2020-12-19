package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;

public class Initializer {

    public static void stationInitialize() {
        for (String stationName : Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역", "양재시민의숲역")) {
            StationRepository.addStation(new Station(stationName));
        }
    }
}
