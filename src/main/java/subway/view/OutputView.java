package subway.view;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String INFO_MARK = "[INFO] ";
    private static final String SEPARATER = "---";
    private static final String TOTAL_DISTANCE = "총 거리: %.0fkm";
    private static final String TOTAL_TIME = "총 소요 시간: %.0f분";

    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        System.out.println();
    }

    public static void printRouteMainMenu() {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public static void printResults(List<String> stations, double weight){
        System.out.println("## 조회 결과");
        printWeights(weight, 0);
        printResultsByStationList(stations);
    }

    private static void printWeights(double distance, double time){
        System.out.println(INFO_MARK + SEPARATER);
        System.out.printf(INFO_MARK + TOTAL_DISTANCE, distance);
        System.out.println();
        System.out.printf(INFO_MARK + TOTAL_TIME , time);
        System.out.println();
        System.out.println(INFO_MARK + SEPARATER);
    }

    private static void printResultsByStationList(List<String> stations){
        for(String station: stations){
            System.out.println(INFO_MARK + station);
        }
    }
}
