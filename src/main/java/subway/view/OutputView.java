package subway.view;

import subway.station.model.Station;

import java.util.List;

public class OutputView {
    private static final String MAIN_MENU_MESSAGE = "## 메인화면";
    private static final String PATH_INQUIRY_MENU = "1. 경로 조회";
    private static final String QUIT_MENU = "Q. 종료\n";
    private static final String EXIT_MESSAGE = "종료되었습니다.";
    private static final String PATH_MENU_MESSAGE = "## 경로 기준";
    private static final String MINIMUM_DISTANCE_MENU = "1. 최단 거리";
    private static final String MINIMUM_TIME_MENU = "2. 최소 시간";
    private static final String RETURN_MENU = "B. 돌아가기\n";
    private static final String INFO = "[INFO] ";
    private static final String DISTANCE_UNIT = "km";
    private static final String RUNTIME_UNIT = "분";

    public static void printMainMenu() {
        System.out.println(MAIN_MENU_MESSAGE);
        System.out.println(PATH_INQUIRY_MENU);
        System.out.println(QUIT_MENU);
    }

    public static void exit() {
        System.out.println(EXIT_MESSAGE);
    }

    public static void printPathMenu() {
        System.out.println(PATH_MENU_MESSAGE);
        System.out.println(MINIMUM_DISTANCE_MENU);
        System.out.println(MINIMUM_TIME_MENU);
        System.out.println(RETURN_MENU);
    }

    public static void printResult(int totalDistance, int totalRunTime, List<Station> path) {
        System.out.println(INFO + "---");
        System.out.println(INFO + "총 거리: " + totalDistance + DISTANCE_UNIT);
        System.out.println(INFO + "총 소요 시간: " + totalRunTime + RUNTIME_UNIT);
        System.out.println(INFO + "---");
        printPath(path);
    }

    private static void printPath(List<Station> path) {
        path.stream()
                .map(Station::getName)
                .map(station -> INFO + station)
                .forEach(System.out::println);
        System.out.println();
    }
}
