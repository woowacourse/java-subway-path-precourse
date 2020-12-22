package subway.service;

import subway.domain.Station;

import java.util.Scanner;

public class TimeRouteService implements RouteService {
    private static final TimeRouteService timeRouteService = new TimeRouteService();

    private TimeRouteService() {
    }

    public static TimeRouteService getInstance() {
        return timeRouteService;
    }

    @Override
    public void routingService(Scanner scanner) {
        try {
            Station startStation = inputStartStations(scanner);
            Station endStation = inputEndStation(scanner);
            isSameName(startStation, endStation);
        } catch (IllegalArgumentException e) {
            goToMenu(e, scanner);
        }
    }
}
