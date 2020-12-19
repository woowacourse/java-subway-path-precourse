package subway.controller;

import subway.DataLoader;
import subway.domain.RouteCheckType;
import subway.service.RouteCheckService;
import subway.view.InputView;

import java.util.Scanner;

public class RouteCheckController {

    private final Scanner scanner;
    private final RouteCheckService routeCheckService;

    public RouteCheckController(Scanner scanner) {
        this.scanner = scanner;
        routeCheckService = new RouteCheckService(scanner);
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
            routeCheckService.getShortestDistance(DataLoader.getDijkstraShortestPathByDistance());
            return;
        }
        if (RouteCheckType.MINIMUM_TIME.equals(routeCheckType)) {
            routeCheckService.getShortestDistance(DataLoader.getDijkstraShortestPathByTime());
        }
    }





}
