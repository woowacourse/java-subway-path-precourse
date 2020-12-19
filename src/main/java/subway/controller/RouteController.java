package subway.controller;

import subway.domain.menu.RouteMenu;
import subway.view.InputView;
import subway.view.output.RouteOutputView;

public class RouteController implements Controller {
    protected static RouteOutputView routeOutputView;
    private RouteMenu routeMenu;
    private static RouteFunction routeFunction;

    public RouteController() {
        routeOutputView = new RouteOutputView();
        routeFunction = new RouteFunction(routeOutputView);
    }

    @Override
    public void run() {
        routeOutputView.printRouteMenu(RouteMenu.list());
        routeMenu = RouteMenu.findMenu(inputRouteMenu());
        routeMenu.run();
    }

    private static String inputRouteMenu() {
        try {
            routeOutputView.selectMenu();
            String menu = InputView.selectMenu();
            return menu;
        } catch (NullPointerException e) {
            return inputRouteMenu();
        }
    }

    public static void shortestDistance() {
        routeFunction.shortestDistance();
    }

    public static void shortestTime() {
        routeFunction.shortestTime();
    }
}
