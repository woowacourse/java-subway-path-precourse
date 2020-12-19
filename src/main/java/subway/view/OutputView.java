package subway.view;

import subway.domain.GraphResult;

public class OutputView {
    private static final String NAVI_FORM = "## %s \n";
    private static final String ERROR_FORM = "[ERROR] %s \n";
    private static final String INFO_FORM = "[INFO} %s \n";
    private static final String MAIN_VIEW = "메인 화면";
    private static final String FUNCTION_VIEW = "경로 기준";
    private static final String TIME_FORM = "총 소요 시간 : %d 분";
    private static final String DISTANCE_FORM = "총 거리 : %d km";
    private static final String DIVIDER = "---";

    public static void printNavi(String message) {
        System.out.printf(NAVI_FORM, message);
    }

    public static void printError(String message) {
        System.out.printf(ERROR_FORM, message);
    }

    public static void printInfo(String message) {
        System.out.printf(INFO_FORM, message);
    }

    public static void printMainView() {
        printNavi(MAIN_VIEW);
        System.out.println(MainView.getViewNames());
    }

    public static void printFunction() {
        printNavi(FUNCTION_VIEW);
        System.out.println(FunctionView.getViewNames());
    }

    public static void printResult(GraphResult result) {
        printInfo(DIVIDER);
        printInfo(String.format(DISTANCE_FORM, result.getDistance()));
        printInfo(String.format(TIME_FORM, result.getTime()));
        printInfo(DIVIDER);
        result.getStations().forEach(station -> printInfo(station.getName()));
        System.out.println();
    }
}
