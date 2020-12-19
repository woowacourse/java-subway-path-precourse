package subway.service;

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

    }
}
