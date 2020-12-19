package subway.view;

import java.util.Scanner;

public class InputView {
    private static InputView inputView;
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void initiate(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public static InputView getInstance() {
        return inputView;
    }

    public String inputMainMenu() {
        System.out.println("\n## 메인 화면\n1. 경로 조회\nQ. 종료");
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public String inputRouteCriteria() {
        System.out.println("\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public String inputStartStationToShortestDistance() {
        System.out.println("## 출발역을 입력하세요.");
        return scanner.nextLine();
    }

    public String inputEndStationToShortestDistance() {
        System.out.println("## 도착역을 입력하세요.");
        return scanner.nextLine();
    }

}
