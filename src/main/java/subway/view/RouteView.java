package subway.view;

import subway.enums.menu.RouteSearchMenu;

import java.util.Arrays;
import java.util.List;

public class RouteView {
    public static void printRouteMenu() {
        System.out.println();
        RouteSearchMenu[] routeMenu = RouteSearchMenu.values();
        List<RouteSearchMenu> menu = Arrays.asList(routeMenu);
        menu.stream().map(RouteSearchMenu::getMenu).forEach(System.out::println);
        System.out.println();
    }
}
