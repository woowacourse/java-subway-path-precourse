package subway.controller;

import subway.DataLoader;
import subway.domain.RouteCheckType;
import subway.service.MinimumTimeService;
import subway.service.ShortestDistanceService;
import subway.view.InputView;

import java.util.Scanner;

public class RouteCheckController {

    private final ShortestDistanceService shortestDistanceService;
    private final MinimumTimeService minimumTimeService;
    private final Scanner scanner;

    public RouteCheckController(Scanner scanner) {
        this.scanner = scanner;
        shortestDistanceService = new ShortestDistanceService(scanner);
        minimumTimeService = new MinimumTimeService(scanner);
    }

    public void runRouteCheckMenu() {
        RouteCheckType routeCheckType;
        do {
            routeCheckType = InputView.inputRouteCheckType(scanner);
            selectRouteCheck(routeCheckType);
        }while (!RouteCheckType.BACK.equals(routeCheckType));
    }

    private void selectRouteCheck(RouteCheckType routeCheckType) {
        if (RouteCheckType.SHORTEST_DISTANCE.equals(routeCheckType)) {
            shortestDistanceService.getShortestDistance(DataLoader.getDijkstraShortestPathByDistance());
            return;
        }
        if (RouteCheckType.MINIMUM_TIME.equals(routeCheckType)) {
            minimumTimeService.getMinimumTime(DataLoader.getDijkstraShortestPathByTime());
        }
    }





}
