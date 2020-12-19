package subway.service;

import subway.controller.RouteController;

import java.util.Scanner;

public interface RouteService {
    void routingService(Scanner scanner);

    default void goToMenu(IllegalArgumentException e, Scanner scanner) {
        System.out.println(e.getMessage());
        RouteController routeController = RouteController.getInstance();
        routeController.mappingRouteMenu(scanner);
    }
}
