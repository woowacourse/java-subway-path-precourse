package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.views.routeviews.RouteInputView;

import java.util.Scanner;

public class DistanceRouteService implements RouteService {
    private static final String NOT_EXIST_STATION_ERROR = "[ERROR} 존재하지 않는 역입니다.";
    private static final String SAME_STATION_ERROR = "[ERROR] 같은 역은 입력할 수 없습니다.";
    private static final DistanceRouteService distanceRouteService = new DistanceRouteService();

    private DistanceRouteService() {
    }

    public static DistanceRouteService getInstance() {
        return distanceRouteService;
    }

    @Override
    public void routingService(Scanner scanner) {
        try {
            Station startStation = new Station(RouteInputView.inputStartStation(scanner));
            isExistStation(startStation);
            Station endStation = new Station(RouteInputView.inputEndStation(scanner));
            isExistStation(endStation);
            isSameName(startStation, endStation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            goToMenu(e, scanner);
        }
    }

    private void isExistStation(Station station) {
        if (!StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(NOT_EXIST_STATION_ERROR);
        }
    }

    private void isSameName(Station startStation, Station endStation) {
        if (startStation.getName().equals(endStation.getName())) {
            throw new IllegalArgumentException(SAME_STATION_ERROR);
        }
    }
}
