package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String RESULT_SCREEN = "\n## 조회 결과";
    private static final String INFO_MESSAGE = "[INFO] %s\n";
    private static final String INFO_TOTAL_DISTANCE_MESSAGE = "[INFO] 총 거리: %dkm\n";
    private static final String INFO_TOTAL_TIME_MESSAGE = "[INFO] 총 소요 시간: %d분\n";
    private static final String DASH = "---";

    private OutputView() {
    }

    public static void printResultMessage(List<Station> stations, int totalDistance, int totalTime) {
        System.out.println(RESULT_SCREEN);
        System.out.printf(INFO_MESSAGE, DASH);
        System.out.printf(INFO_TOTAL_DISTANCE_MESSAGE, totalDistance);
        System.out.printf(INFO_TOTAL_TIME_MESSAGE, totalTime);
        for (Station station : stations) {
            System.out.printf(INFO_MESSAGE, station.getName());
        }
    }
}
