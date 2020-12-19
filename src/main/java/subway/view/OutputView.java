package subway.view;

import java.util.List;

public class OutputView {

    static final String INFO_HEADER = "[INFO] ";
    static final String SEPARATOR = "---";

    public static void printResult(int totalDist, List<String> path) {
        System.out.println("## 조회 결과");
        System.out.println();
        System.out.println(INFO_HEADER + SEPARATOR);
        System.out.println(INFO_HEADER + "총 거리: " + totalDist + "km");
        //System.out.println(INFO_HEADER + "총 소요 시간: " + totalDist + "km");
        System.out.println(INFO_HEADER + SEPARATOR);
        printPath(path);
    }

    public static void printPath(List<String> path) {
        for (String stationName : path) {
            System.out.println(INFO_HEADER + stationName);
        }
    }
}
