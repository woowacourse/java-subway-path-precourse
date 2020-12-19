package subway.util;

import java.util.List;
import java.util.Map;
import subway.controller.Controller;
import subway.domain.Station;

public class PrintUtils {

    private static final String TITLE_MENU_HEADER = "## ";
    private static final String INFO_HEADER = "[INFO] ";
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String MENU_DELIMITER = ". ";
    private static final String MAP_DELIMITER = "---";
    private static final String PATH_TITLE = "조회 결과";

    public static void printShortestPath(int distance, int time, List<Station> stationList) {
        printTitleOrDescription(PATH_TITLE);
        printSerialInfo(MAP_DELIMITER);
        printSerialInfo("총 거리: " + distance + "km");
        printSerialInfo("총 소요 시간: " + time + "분");
        printSerialInfo(MAP_DELIMITER);
        for (Station station : stationList) {
            printSerialInfo(station.getName());
        }

    }

    public static void printMenu(String title, Map<String, Controller> functionMap) {
        printTitleOrDescription(title);
        for (String key : functionMap.keySet()) {
            printMenuIndex(key, functionMap.get(key).getTitle());
        }
        printTitleOrDescription("원하는 기능을 선택하세요.");
    }

    public static void printTitleOrDescription(String title) {
        printLine();
        System.out.println(TITLE_MENU_HEADER + title);
    }

    public static void printMenuIndex(String key, String content) {
        System.out.println(key + MENU_DELIMITER + content);
    }

    public static void printSerialInfo(String info) {
        System.out.println(INFO_HEADER + info);
    }

    public static void printError(String message) {
        printLine();
        System.out.println(ERROR_HEADER + message);
    }

    public static void printLine() {
        System.out.println();
    }

}
