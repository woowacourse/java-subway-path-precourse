package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    public static final String MAIN_HEADER = "## 메인 화면";
    public static final String MAIN_OPTIONS = "1. 경로 조회\nQ. 종료\n";
    public static final String ROUTE_SEARCH_HEADER = "## 경로 기준";
    public static final String ROUTE_SEARCH_OPTIONS = "1. 최단 거리\n2. 최소 시간\nB. 돌아가기\n";
    public static final String CHOOSE_OPTIONS = "## 원하는 기능을 선택하세요.";
    public static final String INPUT_START_STATION = "## 출발역을 입력하세요.";
    public static final String INPUT_END_STATION = "## 도착역을 입력하세요.";
    public static final String SEARCH_RESULT_HEADER = "## 조회 결과";
    public static final String PRINT_LENGTH_PREFIX = "총 거리: ";
    public static final String PRINT_LENGTH_SUFFIX = "km";
    public static final String PRINT_TIME_PREFIX = "총 소요 시간: ";
    public static final String PRINT_TIME_SUFFIX = "분";

    public static final String DOTS = "---";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ERROR_PREFIX = "[ERROR] ";


    private OutputView() {
    }

    public static void printMainView() {
        System.out.println(MAIN_HEADER);
        System.out.println(MAIN_OPTIONS);
        System.out.println(CHOOSE_OPTIONS);
    }

    public static void printRouteSearchView() {
        System.out.println(ROUTE_SEARCH_HEADER);
        System.out.println(ROUTE_SEARCH_OPTIONS);
        System.out.println(CHOOSE_OPTIONS);
    }

    public static void printFromStationMessage() {
        System.out.println(INPUT_START_STATION);
    }

    public static void printToStationMessage() {
        System.out.println(INPUT_END_STATION);
    }

    public static void printSearchResult(int routeLength, int elapsedTime, List<Station> stations) {
        System.out.println(SEARCH_RESULT_HEADER);
        printInfo(DOTS);
        printRouteLength(routeLength);
        printElapsedTime(elapsedTime);
        printInfo(DOTS);
        printStations(stations);
        printEnter();
    }

    private static void printRouteLength(int length) {
        printInfo(PRINT_LENGTH_PREFIX + length + PRINT_LENGTH_SUFFIX);
    }

    private static void printElapsedTime(int time) {
        printInfo(PRINT_TIME_PREFIX + time + PRINT_TIME_SUFFIX);
    }

    private static void printStations(List<Station> stations) {
        for (Station station : stations) {
            printInfo(station.getName());
        }
    }

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    private static void printInfo(String message) {
        System.out.println(INFO_PREFIX + message);
    }

    private static void printEnter() {
        System.out.println();
    }
}
