package subway.service;

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

    }
}
