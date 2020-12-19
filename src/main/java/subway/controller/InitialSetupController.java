package subway.controller;

import subway.domain.*;

import java.util.Arrays;
import java.util.List;

public class InitialSetupController {
    private static final List<String> preregisterStations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");

    private static final String SECOND_LINE = "2호선";
    private static final List<String> secondLineStations = Arrays.asList("교대역", "강남역", "역삼역");
    private static final List<Integer> secondLineDistanceBetweenStations = Arrays.asList(2, 2);
    private static final List<Integer> secondLineTimeBetweenStations = Arrays.asList(3, 3);

    private static final String THIRD_LINE = "3호선";
    private static final List<String> thirdLineStations = Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역");
    private static final List<Integer> thirdLineDistanceBetweenStations = Arrays.asList(3, 6, 1);
    private static final List<Integer> thirdLineTimeBetweenStations = Arrays.asList(2, 5, 1);

    private static final String NEW_BOONDANG_LINE = "신분당선";
    private static final List<String> newBoondangLineStations = Arrays.asList("강남역", "양재역", "양재시민의숲역");
    private static final List<Integer> newBoondangLineDistanceBetweenStations = Arrays.asList(2, 10);
    private static final List<Integer> newBoondangLineTimeBetweenStations = Arrays.asList(8, 3);

    private static final int INITIALIZE = 0;
    private static final int NEXT_INDEX = 1;

    public static void initialSetup() {
        initialSetupStation();
        initialSetupSecondLine();
        initialSetupThirdLine();
        initialSetupNewBoondangLine();
    }

    private static void initialSetupStation() {
        for (String stationName : preregisterStations) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
            DistanceGraphRepository.addStation(station);
            TimeGraphRepository.addStation(station);
        }
    }

    private static void initialSetupSecondLine() {
        initialSetupLine(SECOND_LINE, secondLineStations);
        initialSetupTimeRouteInfo(secondLineTimeBetweenStations, secondLineStations);
        initialSetupDistanceRouteInfo(secondLineDistanceBetweenStations, secondLineStations);
    }

    private static void initialSetupThirdLine() {
        initialSetupLine(THIRD_LINE, thirdLineStations);
        initialSetupTimeRouteInfo(thirdLineTimeBetweenStations, thirdLineStations);
        initialSetupDistanceRouteInfo(thirdLineDistanceBetweenStations, thirdLineStations);
    }

    private static void initialSetupNewBoondangLine() {
        initialSetupLine(NEW_BOONDANG_LINE, newBoondangLineStations);
        initialSetupTimeRouteInfo(newBoondangLineTimeBetweenStations, newBoondangLineStations);
        initialSetupDistanceRouteInfo(newBoondangLineDistanceBetweenStations, newBoondangLineStations);
    }

    private static void initialSetupLine(String lineName, List<String> lineStations) {
        Line line = new Line(lineName);
        for (String stationName : lineStations) {
            Station station = StationRepository.getStationByName(stationName);
            station.addBelongToWhichLine(line);
            line.addStationsInLine(station);
        }
        LineRepository.addLine(line);
    }

    private static void initialSetupTimeRouteInfo(List<Integer> timeBetweenStations, List<String> lineStations) {
        int index = INITIALIZE;
        for (int time : timeBetweenStations) {
            Station source = StationRepository.getStationByName(lineStations.get(index));
            Station destination = StationRepository.getStationByName(lineStations.get(index + NEXT_INDEX));
            TimeGraphRepository.addTimeBetweenStations(source, destination, time);
        }
    }

    private static void initialSetupDistanceRouteInfo(List<Integer> distanceBetweenStations, List<String> lineStations) {
        int index = INITIALIZE;
        for (int distance : distanceBetweenStations) {
            Station source = StationRepository.getStationByName(lineStations.get(index));
            Station destination = StationRepository.getStationByName(lineStations.get(index + NEXT_INDEX));
            DistanceGraphRepository.addTimeBetweenStations(source, destination, distance);
        }
    }
}
