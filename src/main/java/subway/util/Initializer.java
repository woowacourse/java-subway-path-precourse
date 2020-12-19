package subway.util;

import subway.domain.*;

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
        enrollNearbyStation();
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

    private void enrollNearbyStation() {
        Station kyodae = StationRepository.findStationByName("교대역");
        Station kangnam = StationRepository.findStationByName("강남역");
        Station yeoksam = StationRepository.findStationByName("역삼역");
        Station southterminal = StationRepository.findStationByName("남부터미널역");
        Station yangjae = StationRepository.findStationByName("양재역");
        Station forest = StationRepository.findStationByName("양재시민의숲역");
        Station maebong = StationRepository.findStationByName("매봉역");
        mappingNearbyStation(kyodae, kangnam, 2, 3);
        mappingNearbyStation(kangnam, yeoksam, 2, 3);
        mappingNearbyStation(kyodae, southterminal, 3, 2);
        mappingNearbyStation(yangjae, southterminal, 6, 5);
        mappingNearbyStation(yangjae, maebong, 1, 1);
        mappingNearbyStation(kangnam, yangjae, 2, 8);
        mappingNearbyStation(yangjae, forest, 10, 3);
    }

    private void mappingNearbyStation(Station startStation, Station arrivedStation, int distance, int time) {
        startStation.addNearbyStation(new NearbyStation(arrivedStation, distance, time));
        arrivedStation.addNearbyStation(new NearbyStation(startStation, distance, time));
        PathCalculator.addWeightInfo(startStation.getName(), arrivedStation.getName(), distance, time);
    }
}
