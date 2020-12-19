package controller;

import java.util.Scanner;

public class ShortestDistanceController {
    public static void run(Scanner scanner) {
        System.out.println("## 출발역을 입력하세요.");
        String departureStation = scanner.nextLine();
        System.out.println();
        System.out.println("## 도착역을 입력하세요.");
        String arrivalStation = scanner.nextLine();
        System.out.println();

        searchResult();
    }
    public static void searchResult() {
        System.out.println("[INFO] ---\n" +
                "[INFO] 총 거리: " + "몇키로" + "\n" +
                "[INFO] 총 소요 시간: " + "몇시간" + "\n" +
                "[INFO] ---");

    }
}
