package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String INFO = "[INFO] ";
    private static final String INFO_LINE = INFO + "---";

    public static void printMainScene() {
        System.out.println(NEW_LINE + "## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public static void printPathScene() {
        System.out.println(NEW_LINE + "## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public static void printInquiryResult(List<Station> stations, int distance, int time) {
        System.out.println(NEW_LINE + INFO_LINE);
        System.out.println(INFO + "총 거리: " + distance);
        System.out.println(INFO + "총 소요 시간: " + time);
        System.out.println(INFO_LINE);

        printStations(stations);
    }

    private static void printStations(List<Station> stations) {
        stations.forEach(station -> System.out.println(INFO + station.getName()));
    }
}
