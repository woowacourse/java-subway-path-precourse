package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;

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

    public static void displayPath(Scanner kbd, int distance, int time, Line line) {
        System.out.println("## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: "+ distance + "km");
        System.out.println("[INFO] 총 소요 시간: "+ time + "분");
        System.out.println("[INFO] ---");
        line.displayLine();
        startProgram(kbd);
    }

    public static void finishProgram() {
        System.out.println("## 프로그램 종료");
    }
}
