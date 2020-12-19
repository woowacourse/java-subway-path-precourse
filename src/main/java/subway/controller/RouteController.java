package subway.controller;

import subway.domain.menu.RouteMenu;
import subway.view.InputView;
import subway.view.output.RouteOutputView;

public class RouteController implements Controller {
    protected static RouteOutputView routeOutputView;
    private RouteMenu routeMenu;

    public RouteController() {
        routeOutputView = new RouteOutputView();
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
        System.out.println("최단 거리 메뉴 실행 \n");
    }

    public static void shortestTime() {
        System.out.println("최단 시간 메뉴 실행 \n");
    }
}
