package subway.service;

import subway.domain.Station;

import java.util.Scanner;

public class DistanceRouteService implements RouteService {

    private static final DistanceRouteService distanceRouteService = new DistanceRouteService();

    private DistanceRouteService() {
    }

    public static DistanceRouteService getInstance() {
        return distanceRouteService;
    }

    @Override
    public void routingService(Scanner scanner) {
        try {
            Station startStation = inputStartStations(scanner);
            Station endStation = inputEndStation(scanner);
            RouteService.isSameName(startStation, endStation);
        } catch (IllegalArgumentException e) {
            goToMenu(e, scanner);
        }
    }
}
