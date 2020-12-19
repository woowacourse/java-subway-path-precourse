package subway.view;

import subway.domain.calculator.Result;

import java.util.List;

public class OutputView {
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String GUIDE_PREFIX = "## ";
    private static final String DIVIDING_LINE = "---";
    private static final String TOTAL_DISTANCE = "총 거리:";
    private static final String TOTAL_TIME = "총 소요 시간:";

    public static void printRoute(Result result) {
        List<String> route = result.getRoute();
        printResult(DIVIDING_LINE);
        printResult(TOTAL_DISTANCE + result.getDistance());
        printResult(TOTAL_TIME + result.getTime());
        printResult(DIVIDING_LINE);
        route.forEach(OutputView::printStation);
    }

    private static void printStation(String station) {
        printResult(station);
    }

    public static void printError(String message) {
        System.out.println();
        print(ERROR_PREFIX + message);
    }

    public static void printResult(String message) {
        print(RESULT_PREFIX + message);
    }

    public static void printlnResult(String message) {
        System.out.println();
        print(RESULT_PREFIX + message);
    }

    public static void printGuide(String message) {
        System.out.println();
        print(GUIDE_PREFIX + message);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
