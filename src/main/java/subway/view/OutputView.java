package subway.view;

import subway.domain.MainAction;
import subway.domain.PathAction;

import java.util.List;

public class OutputView {

    public static final String NOTICE_HEAD = "## ";
    private static final String DELIMITER_ACTION = ". ";
    private static final String INFO_HEAD = "[INFO] ";
    private static final String ERROR_HEAD = "[ERROR] ";
    private static final String DELIMITER_STATION = "---";

    public static void printMain() {
        System.out.println();
        System.out.println(NOTICE_HEAD + "메인 화면");
        for (MainAction mainAction : MainAction.values()) {
            System.out.println(mainAction.getActionNumber() + DELIMITER_ACTION + mainAction.getActionName());
        }
    }

    public static void printPathAction() {
        System.out.println();
        System.out.println(NOTICE_HEAD + "경로 기준");
        for (PathAction pathAction : PathAction.values()) {
            System.out.println(pathAction.getActionNumber() + DELIMITER_ACTION + pathAction.getActionName());
        }
    }

    public static void printError(String message) {
        System.out.println();
        System.out.println(ERROR_HEAD + message);
    }

    public static void printInfo(String message) {
        System.out.println(INFO_HEAD + message);
    }

    public static void printReport(int totalLength, int totalTime) {
        System.out.println();
        System.out.println(NOTICE_HEAD+"조회 결과");
        printInfo(DELIMITER_STATION);
        printInfo(String.format("총 거리: %dkm", totalLength));
        printInfo(String.format("총 소요 시간: %d분",totalTime));
        printInfo(DELIMITER_STATION);
    }

    public static void printStations(List<String> stations) {
        for(String stationName: stations) {
            printInfo(stationName);
        }
    }
}
