package subway.view;

import subway.menu.MainMenu;
import subway.menu.PathMenu;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String MAIN_HEADER = "\n## 메인 화면";
    private static final String PATH_HEADER = "\n## 경로 기준";
    private static final String PATH_RESULT_HEADER = "\n## 조회 결과";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String THREE_DASHES = "---";
    private static final String TOTAL_DISTANCE_PREFIX = "총 거리 : ";
    private static final String TOTAL_DISTANCE_SUFFIX = "km";
    private static final String TOTAL_TIME_PREFIX = "총 소요 시간 : ";
    private static final String TOTAL_TIME_SUFFIX = "분";

    public static void printMainMenu() {
        System.out.println(MAIN_HEADER);
        Arrays.stream(MainMenu.values())
                .map(MainMenu::getMessage)
                .forEach(System.out::println);
    }

    public static void printPathMenu() {
        System.out.println(PATH_HEADER);
        Arrays.stream(PathMenu.values())
                .map(PathMenu::getMessage)
                .forEach(System.out::println);
    }

    public static void printPathResult(List<String> stations, int distance, int time) {
        System.out.println(PATH_RESULT_HEADER);
        printDistanceAndTime(distance, time);
        stations.forEach(OutputView::printEachStation);
    }

    private static void printDistanceAndTime(int distance, int time) {
        System.out.println(INFO_PREFIX + THREE_DASHES);
        System.out.println(INFO_PREFIX + TOTAL_DISTANCE_PREFIX + distance + TOTAL_DISTANCE_SUFFIX);
        System.out.println(INFO_PREFIX + TOTAL_TIME_PREFIX + time + TOTAL_TIME_SUFFIX);
        System.out.println(INFO_PREFIX + THREE_DASHES);
    }

    private static void printEachStation(String stationName) {
        System.out.println(INFO_PREFIX + stationName);
    }
}
