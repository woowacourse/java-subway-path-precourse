package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class Initializer {
    private static final List<String> stations =
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> lines = Arrays.asList("2호선", "3호선", "신분당선");
    private static final List<String> secondLineStations = Arrays.asList("교대역", "강남역", "역삼역");
    private static final List<String> thirdLineStations = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
    private static final List<String> shinbundangLineStations = Arrays.asList("강남역", "양재역", "양재시민의숲역");

    public void init() {
        createStation();
        createLine();
        enrollStationOnLine();
    }

    private void createStation() {
        stations.forEach(Station::from);
    }

    private void createLine() {
        lines.forEach(Line::from);
    }

    private void enrollStationOnLine() {
        Line secondLine = LineRepository.findLineByName("2호선");
        Line thirdLine = LineRepository.findLineByName("3호선");
        Line shinbundangLine = LineRepository.findLineByName("신분당선");

        secondLineStations.stream()
                .map(StationRepository::findStationByName)
                .forEach(secondLine::addStation);
        thirdLineStations.stream()
                .map(StationRepository::findStationByName)
                .forEach(thirdLine::addStation);
        shinbundangLineStations.stream()
                .map(StationRepository::findStationByName)
                .forEach(shinbundangLine::addStation);
    }
}
