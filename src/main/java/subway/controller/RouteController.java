package subway.controller;

import subway.views.routeviews.RouteOutputView;

import java.util.Scanner;

public class RouteController {
    private static final RouteController routeController = new RouteController();

    private RouteController() {
    }

    public static RouteController getInstance() {
        return routeController;
    }

    public void mappingMenu(Scanner scanner) {
        RouteOutputView.printRouteMenu();
    }
}
