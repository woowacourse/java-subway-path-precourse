package subway;

import java.util.Stack;

public class PrintScreen {

    public static void printMain() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");

        selectFunction();
    }

    public static void selectFunction() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public static void selectStandard() {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");

        selectFunction();
    }

    public static void printInputStartStation() {
        System.out.println("## 출발역을 입력하세요.");
    }

    public static void printInputArriveStation() {
        System.out.println("## 도착역을 입력하세요.");
    }

    public static void printMinPathStationToArrive(String kind, Stack<String> stack, int firstMinCost, int secondMinCost) {
        System.out.println("[INFO] ---");
        if (kind.equals(Constants.DISTANCE_COST)) {
            System.out.println("[INFO] 총 거리 : " + firstMinCost);
            System.out.println("[INFO] 총 소요시간 : " + secondMinCost);
        }
        if (kind.equals(Constants.TIME_COST)) {
            System.out.println("[INFO] 총 소요시간 : " + firstMinCost);
            System.out.println("[INFO] 총 거리 : " + secondMinCost);
        }
        System.out.println("[INFO] ---");
        while (!stack.isEmpty()) {
            System.out.println("[INFO] " + stack.pop());
        }
        System.out.println();
    }
}
