package subway.view;

import java.util.Arrays;
import subway.controller.MainFunction;
import subway.controller.RouteFunction;
import subway.domain.RouteResultDTO;

public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String NOTICE_PREFIX = "## ";
    public static final String BORDER_LINE = "---";
    public static final String MAIN_TITLE = "메인 화면";
    public static final String CHOOSE_FUNCTION = "원하는 기능을 선택하세요.";
    public static final String ROUTE_TITLE = "경로 기준";
    public static final String RETRIEVE_RESULT = "조회 결과";
    public static final String TOTAL_DISTANCE = "총 거리: ";
    public static final String TOTAL_TIME = "총 소요 시간: ";
    public static final String KM = "km";
    public static final String MINUTE = "분";

    public static void printRoute(RouteResultDTO routeResultDTO) {
        printNotice(RETRIEVE_RESULT);
        System.out.println(BORDER_LINE);
        printInfo(TOTAL_DISTANCE + routeResultDTO.getDistanceWeight() + KM);
        printInfo(TOTAL_TIME + routeResultDTO.getTimeWeight() + MINUTE);
        System.out.println(BORDER_LINE);
        routeResultDTO.getPath().forEach(OutputView::printInfo);
    }

    public static void printError(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void printInfo(String s) {
        System.out.println(INFO_PREFIX + s);
    }

    public static void printMainFunction(MainFunction[] mainFunctions) {
        printNotice(MAIN_TITLE);
        Arrays.stream(mainFunctions)
                .forEach(System.out::println);
        printNotice(CHOOSE_FUNCTION);
    }

    public static void printNotice(String notice) {
        System.out.println();
        System.out.println(NOTICE_PREFIX + notice);
    }

    public static void printRouteFunction(RouteFunction[] routeFunctions) {
        printNotice(ROUTE_TITLE);
        Arrays.stream(routeFunctions)
                .forEach(System.out::println);
        printNotice(CHOOSE_FUNCTION);
    }
}
