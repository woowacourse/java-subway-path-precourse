package subway.view;

import java.util.List;

public class OutputView {
    private static final String INFO = "[INFO] ";
    private static final String DASH = "---";
    private static final String RESULT = "## 조회 결과";
    private static final String TOTAL_DISTANCE = "총 거리: ";
    private static final String TOTAL_TIME = "총 소요 시간: ";
    private static final String KM = "km";
    private static final String MINUTE = "분";
    private static final String EXIT_PROGRAM = "프로그램을 종료합니다.";

    private OutputView() {
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public static void printExit() {
        System.out.println(INFO + EXIT_PROGRAM);
        System.out.println();
    }

    public static void printResult(int distance, int time, List<String> path) {
        System.out.println(RESULT);
        System.out.println(INFO + DASH);
        System.out.println(INFO + TOTAL_DISTANCE + distance + KM);
        System.out.println(INFO + TOTAL_TIME + time + MINUTE);
        System.out.println(INFO + DASH);
        path.forEach(stationName -> System.out.println(INFO + stationName));
        System.out.println();
    }
}
