package subway.view;

import subway.domain.Route;
import subway.enums.info.RouteResultInfo;
import subway.enums.info.RouteSearchInfo;
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

    public static void askInputDeparture() {
        System.out.println(RouteSearchInfo.INPUT_DEPARTURE.getInfo());
    }

    public static void askInputArrival() {
        System.out.println(RouteSearchInfo.INPUT_ARRIVAL.getInfo());
    }

    public static void printResult(int distance, int time, List<String> shortestPath) {
        System.out.println(RouteResultInfo.TITLE.getValue());
        System.out.println(RouteResultInfo.DELIMITER.getValue());
        System.out.println(RouteResultInfo.TOTAL_DISTANCE.getValue()
                + distance
                + RouteResultInfo.KM.getValue());
        System.out.println(RouteResultInfo.TOTAL_TIME.getValue()
                + time + RouteResultInfo.MIN.getValue());
        System.out.println(RouteResultInfo.DELIMITER.getValue());
        for (String path : shortestPath) {
            System.out.println(RouteResultInfo.INFO.getValue() +  path);
        }

    }
}
