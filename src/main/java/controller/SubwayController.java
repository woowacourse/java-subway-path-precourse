package controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

import java.util.List;
import java.util.Scanner;

public class SubwayController {
    private static String userInput;

    public SubwayController(Scanner scanner) {
        run(scanner);
    }

    public static void run(Scanner scanner) {
        System.out.println("## 메인 화면\n" +
                "1. 역 관리\n" +
                "Q. 종료\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");
        userInput = scanner.nextLine();
        mainSelect(scanner);
    }

    private static void mainSelect(Scanner scanner) {
        boolean inputCheck = false;
        if (userInput.equals("1")) {
            inputCheck = true;
            printSubway();
            run(scanner);
        }
        if (userInput.equals("Q")) {
            inputCheck = true;
            scanner.close();
        }
        if (inputCheck == false) {
            System.out.println("[ERROR] 올바른 문자를 입력해주세요.");
            run(scanner);
        }
    }

    private static void printSubway() {
        System.out.println("## 지하철 노선도");
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
            System.out.println("[INFO] ---");
            List<Station> stations = line.getSection();
            for (Station station : stations) {
                System.out.println("[INFO] " + station.getName());
            }
            System.out.println();
        }
    }
}
