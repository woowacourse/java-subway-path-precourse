package subway;

import subway.controller.TransitRouteController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        TransitRouteController.run();
        // TODO: 프로그램 구현
    }

    public static void init() {
        List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        stations.stream()
                .forEach(station -> StationRepository.addStation(new Station(station)));
        initStationWithLine("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        initStationWithLine("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        initStationWithLine("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
    }

    public static void initStationWithLine(String lineName, List<String> stationNames) {
        List<Station> stations = stationNames.stream()
                .map(stationName -> StationRepository.findStationByName(stationName))
                .collect(Collectors.toList());
        Line line = new Line(lineName);
        LineRepository.addLine(line);
    }
}
