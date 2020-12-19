package subway.service;

import subway.controller.RouteController;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.views.routeviews.RouteInputView;

import java.util.Scanner;

public interface RouteService {
    String NOT_EXIST_STATION_ERROR = "[ERROR} 존재하지 않는 역입니다.";
    String SAME_STATION_ERROR = "[ERROR] 같은 역은 입력할 수 없습니다.";
    String NOT_CONNECTED_STATIONS = "[ERROR] 두 역이 연결되어 있지 않습니다.";

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
        routeController.mappingRouteMenu(scanner);
    }

    static void isExistStation(Station station) {
        if (!StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(NOT_EXIST_STATION_ERROR);
        }
    }

    static void isSameName(Station startStation, Station endStation) {
        if (startStation.getName().equals(endStation.getName())) {
            throw new IllegalArgumentException(SAME_STATION_ERROR);
        }
    }

    static void isAvailableRoute(Station startStation, Station endStation) {
        if (!LineRepository.isConnected(startStation, endStation)) {
            throw new IllegalArgumentException(NOT_CONNECTED_STATIONS);
        }
    }
}
