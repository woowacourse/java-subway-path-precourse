package subway.view;

import subway.domain.Line;

import java.util.Scanner;

import static subway.Application.startProgram;

public class View {
    public static void showMainMenu() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public static void showPathMenu() {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public static void displayPath(Line line, int time, int distance) {
        System.out.println("\n## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: "+ distance + "km");
        System.out.println("[INFO] 총 소요 시간: "+ time + "분");
        System.out.println("[INFO] ---");
        line.displayLine();
    }

    public static void finishProgram() {
        System.out.println("## 프로그램 종료");
    }
}
