package subway.view;

import subway.domain.GraphResult;

public class OutputView {
    private static final String NAVI_FORM = "## %s \n";
    private static final String ERROR_FORM = "[ERROR] %s \n";
    private static final String INFO_FORM = "[INFO} %s \n";

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
        printNavi("메인 화면");
        System.out.println(MainView.getViewNames());
    }

    public static void printFunction() {
        printNavi("경로 기준");
        System.out.println(FunctionView.getViewNames());
    }

    public static void printResult(GraphResult resultByDistance) {
        printInfo("---");
        printInfo("총 거리 : " +resultByDistance.getDistance() + "km");
        printInfo("총 소요 시간 : " + resultByDistance.getTime() + "분");
        printInfo("---");
        resultByDistance.getStations().forEach(station -> printInfo(station.getName()));
        System.out.println();
    }
}
