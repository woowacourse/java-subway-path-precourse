package subway.userinterface;

import subway.domain.Station;

import java.util.List;

public class InfoOutput {
    private static final String INFO = "[INFO] ";
    private static final String LINE_DIVISION = "---";

    public static void printSearchResult(int distance, int time, List<Station> stations) {
        Input.printResultNotification();
        System.out.println(LINE_DIVISION);
        System.out.println(INFO+"총 거리 : "+ distance+"km");
        System.out.println(INFO+"총 시간 : "+ distance+"분");
        System.out.println(LINE_DIVISION);
        for (Station station : stations) {
            System.out.println(INFO+station.getName());
        }
    }
}
