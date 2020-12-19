package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.views.routeviews.RouteInputView;

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
            inputStations(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            goToMenu(e, scanner);
        }
    }
}
