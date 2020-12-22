package subway.views.routeviews;

import subway.domain.Station;
import subway.menus.RouteMenu;
import subway.views.OutputView;

import java.util.Arrays;
import java.util.List;

public class RouteOutputView implements OutputView {
    private static final String ROUTE_SCREEN_MESSAGE = "## 경로 기준";
    private static final String INPUT_START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String INPUT_END_STATION_MESSAGE = "## 도착역을 입력하세요.";
    private static final String ROUTE_RESULT_MESSAGE = "## 조회 결과";
    private static final String INFORMATION = "[INFO] ";
    private static final String SEPARATOR = "---";
    private static final String TOTAL_DISTANCE_MESSAGE = "총 거리: ";
    private static final String TOTAL_TIME_MESSAGE = "총 소요 시간: ";
    private static final String DISTANCE_UNIT = "km";
    private static final String TIME_UNIT = "분";

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

    public static void printRoutedMapWithResources(List<Station> stationList, int distance, int time) {
        System.out.println(LINE_WRAP + ROUTE_RESULT_MESSAGE);
        System.out.println(INFORMATION + SEPARATOR);
        System.out.println(INFORMATION + TOTAL_DISTANCE_MESSAGE + distance + DISTANCE_UNIT);
        System.out.println(INFORMATION + TOTAL_TIME_MESSAGE + time + TIME_UNIT);
        System.out.println(INFORMATION + SEPARATOR);
        printRoute(stationList);
        System.out.println();
    }

    static void printRoute(List<Station> stationList) {
        stationList.stream()
            .map(Station::getName)
            .forEach(stationName -> System.out.println(INFORMATION + stationName));
    }
}
