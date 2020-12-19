package subway.view;

import java.util.List;

public class OutputView {
    public static final String INFO = "[INFO] ";
    public static final String INFO_LINE = INFO + "---";
    public static final String TOTAL_DISTANCE = "총 거리: ";
    public static final String DISTANCE_UNIT = "km";
    public static final String TOTAL_TIME = "총 소요 시간: ";
    public static final String TIME_UNIT = "분";
    public static final String ERROR = "\n[ERROR] ";
    public static final String SAME_DEPARTURE_AND_ARRIVAL = "출발역과 도착역이 동일합니다.";
    public static final String CANNOT_SELECT_MENU = "선택할 수 없는 기능입니다.";
    public static final String NOT_EXIST_STATION = "등록되지 않은 역이름 입니다.";
    public static final String RESULT = "\n## 조회 결과";

    public static void sameStationError() {
        System.out.println(ERROR + SAME_DEPARTURE_AND_ARRIVAL);
    }

    public static void notExistStationError() {
        System.out.println(ERROR + NOT_EXIST_STATION);
    }

    public static void cannotSelectMenuError() {
        System.out.println(ERROR + CANNOT_SELECT_MENU);
    }

    public static void printInfoLine() {
        System.out.println(INFO_LINE);
    }

    public static void printMinDistanceAndTime(List<String> stations, double distance ) {
        System.out.println(RESULT);
        printInfoLine();
        System.out.println(INFO + TOTAL_DISTANCE + (int) distance + DISTANCE_UNIT);
        System.out.println(INFO + TOTAL_TIME + TIME_UNIT);
        printInfoLine();
        stations.stream().forEach(station -> System.out.println(INFO + station));
        System.out.println();
    }

    public static void printMinTimeAndDistance(List<String> stations, double time ) {
        System.out.println(RESULT);
        printInfoLine();
        System.out.println(INFO + TOTAL_DISTANCE + DISTANCE_UNIT);
        System.out.println(INFO + TOTAL_TIME + (int) time + TIME_UNIT);
        printInfoLine();
        stations.stream().forEach(station -> System.out.println(INFO + station));
        System.out.println();
    }

}
