package subway.userinterface;

import subway.domain.Station;

import java.util.List;

public class InfoOutput {
    private static final String INFO = "[INFO] ";
    private static final String LINE_DIVISION = "---";
    private static final String TOTAL_DISTANCE = "총 거리 : ";
    private static final String TOTAL_TIME = "총 시간 : ";
    private static final String DISTANCE_UNIT = "km";
    private static final String TIME_UNIT = "분";

    public static void printSearchResult(int distance, int time, List<Station> stations) {
        Input.printResultNotification();
        System.out.println(LINE_DIVISION);
        System.out.println(INFO + TOTAL_DISTANCE + distance + DISTANCE_UNIT);
        System.out.println(INFO + TOTAL_TIME + time + TIME_UNIT);
        System.out.println(LINE_DIVISION);
        for (Station station : stations) {
            System.out.println(INFO + station.getName());
        }
    }
}
