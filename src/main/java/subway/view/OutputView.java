package subway.view;

import java.util.List;
import subway.domain.section.SectionRepository;

public class OutputView {

    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        printEmptyLine();
    }

    public static void printFindRouteMenu() {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
        printEmptyLine();
    }

    public static void printShortestDistanceResult(int distance, List<String> namesOfStations) {
        System.out.println("## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: " + distance + "km");
        System.out.println(
            "[INFO] 총 소요 시간: " + SectionRepository.calculateTimeSum(namesOfStations) + "분");
        System.out.println("[INFO] ---");
        for (String name : namesOfStations) {
            System.out.println("[INFO] " + name);
        }
        printEmptyLine();
    }

    public static void printShortestTimeResult(int time, List<String> namesOfStations) {
        System.out.println("## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println(
            "[INFO] 총 거리: " + SectionRepository.calculateDistanceSum(namesOfStations) + "km");
        System.out.println(
            "[INFO] 총 소요 시간: " + time + "분");
        System.out.println("[INFO] ---");
        for (String name : namesOfStations) {
            System.out.println("[INFO] " + name);
        }
        printEmptyLine();
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
