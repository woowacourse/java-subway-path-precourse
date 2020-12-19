package subway;

import java.util.List;
import subway.domain.Station;

public class ResultPrinter {
    private static final String RESULT_TITLE
        = "\n## 조회 결과";
    public static final String INFO_PREFIX = "[INFO] ";
    private static final String INFO_SPLIT_LINE = INFO_PREFIX + "---";
    private static final String TOTAL_DISTANCE_RESULT_FORMAT = "총 거리: %dkm";
    private static final String TOTAL_TIME_RESULT_FORMAT = "총 소요 시간: %d분";

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void printInfoSplitLine() {
        System.out.println(INFO_SPLIT_LINE);
    }

    public static void resultPrinter(List<Station> path, int totalDistance,
        int totalTime) {
        ResultPrinter.printResultTitle();
        ResultPrinter.printInfoSplitLine();
        System.out.printf(ResultPrinter.INFO_PREFIX + TOTAL_DISTANCE_RESULT_FORMAT, totalDistance);
        System.out.println();
        System.out.printf(ResultPrinter.INFO_PREFIX + TOTAL_TIME_RESULT_FORMAT, totalTime);
        System.out.println();
        ResultPrinter.printInfoSplitLine();
        for (Station station : path) {
            System.out.println(ResultPrinter.INFO_PREFIX + station.getName());
        }
    }
}
