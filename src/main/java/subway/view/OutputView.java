package subway.view;

import java.util.List;

public class OutputView {
    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public static void printRouteMenu() {
        println();
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public static void printMenuSelectionGuide() {
        println();
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static void printQuit() {
        println();
        System.out.println("## 종료합니다. 이용해 주셔서 감사합니다.");
    }

    public static void printStartStationGuide() {
        println();
        System.out.println("## 출발역을 입력하세요.");
    }

    public static void printEndStationGuide() {
        println();
        System.out.println("## 도착역을 입력하세요.");
    }
    
    public static void printResult(List<String> results) {
        println();
        System.out.println("## 조회 결과");
        for (String result : results) {
            System.out.println("[INFO] " + result);
        }
    }

    public static void printError(String error) {
        println();
        System.out.println(error);
    }

    public static void println() {
        System.out.println();
    }
}
