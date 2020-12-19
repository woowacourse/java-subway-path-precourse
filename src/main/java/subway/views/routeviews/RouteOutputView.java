package subway.views.routeviews;

import subway.menus.RouteMenu;
import subway.views.OutputView;

import java.util.Arrays;

public class RouteOutputView implements OutputView {
    private static final String ROUTE_SCREEN_MESSAGE = "## 경로 기준";
    private static final String INPUT_START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String INPUT_END_STATION_MESSAGE = "## 도착역을 입력하세요.";

    public static void printRouteMenu() {
        System.out.println(LINE_WRAP + ROUTE_SCREEN_MESSAGE);
        Arrays.stream(RouteMenu.values())
            .forEach(System.out::println);
    }

    public static void printStartStationMessage() {
        System.out.println(LINE_WRAP + INPUT_START_STATION_MESSAGE);
    }

    public static void printEndStationMessage() {
        System.out.println(LINE_WRAP + INPUT_END_STATION_MESSAGE);
    }
}
