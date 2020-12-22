package subway.service;

import subway.controller.RouteController;
import subway.domain.Section;
import subway.domain.Station;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;
import subway.views.routeviews.RouteInputView;
import subway.views.routeviews.RouteOutputView;

import java.util.List;
import java.util.Scanner;

public interface RouteService {
    String NOT_EXIST_STATION_ERROR = "\n[ERROR] 존재하지 않는 역입니다.";
    String SAME_STATION_ERROR = "\n[ERROR] 같은 역은 입력할 수 없습니다.";

    void routingService(Scanner scanner);

    default Station inputStartStations(Scanner scanner) {
        Station startStation = new Station(RouteInputView.inputStartStation(scanner));
        isExistStation(startStation);
        return startStation;
    }

    default Station inputEndStation(Scanner scanner) {
        Station endStation = new Station(RouteInputView.inputEndStation(scanner));
        isExistStation(endStation);
        return endStation;
    }

    default void goToMenu(IllegalArgumentException e, Scanner scanner) {
        System.out.println(e.getMessage());
        RouteController routeController = RouteController.getInstance();
        routeController.mappingMenu(scanner);
    }

    static void isExistStation(Station station) {
        if (!StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(NOT_EXIST_STATION_ERROR);
        }
    }

    default void isSameName(Station startStation, Station endStation) {
        if (startStation.getName().equals(endStation.getName())) {
            throw new IllegalArgumentException(SAME_STATION_ERROR);
        }
    }

    default void calculateTotalDistanceAndTime(List<Station> shortestRouteStationList) {
        int totalDistance = calculateTotalDistance(shortestRouteStationList);
        int totalTime = calculateTotalTime(shortestRouteStationList);
        RouteOutputView.printRoutedMapWithResources(shortestRouteStationList, totalDistance, totalTime);
    }

    default int calculateTotalDistance(List<Station> shortestRouteStationList) {
        int totalDistance = 0;
        for (int i = 0; i < shortestRouteStationList.size()-1 ; i++) {
            Section section = new Section(shortestRouteStationList.get(i), shortestRouteStationList.get(i + 1));
            totalDistance += SectionRepository.sections().get(section).getDistance().getDistance();
        }
        return totalDistance;
    }

    default int calculateTotalTime(List<Station> shortestRouteStationList) {
        int totalTime = 0;
        for (int i = 0; i < shortestRouteStationList.size()-1 ; i++) {
            Section section = new Section(shortestRouteStationList.get(i), shortestRouteStationList.get(i + 1));
            totalTime += SectionRepository.sections().get(section).getTime().getTime();
        }
        return totalTime;
    }
}
