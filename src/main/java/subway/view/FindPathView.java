package subway.view;

import java.util.Scanner;

public class FindPathView {
    public static final String PATH = "## 경로 기준";
    public static final String PATH_MENU_DISTANCE = "1. 최단 거리";
    public static final String PATH_MENU_TIME = "2. 최소 시간";
    public static final String PATH_MENU_BACK = "B. 돌아가기";
    public static final String PATH_ASK_START = "## 출발역을 입력하세요.";
    public static final String PATH_ASK_DESTINATION = "## 도착역을 입력하세요.";
    public static final String PATH_ASK_COMMAND = "## 원하는 기능을 선택하세요.";

    public static void printFindPathView(Scanner scanner) {
        printPathMenu();
        String command = Input.getInput(scanner);
        generateCommand(command, scanner);
    }

    private static void printPathMenu() {
        System.out.println(PATH);
        System.out.println(PATH_MENU_DISTANCE);
        System.out.println(PATH_MENU_TIME);
        System.out.println(PATH_MENU_BACK);
    }

    public static void generateCommand(String command, Scanner scanner) {
        if(command.equals("1")) {

        }
        if(command.equals("2")) {

        }
        if(command.equals("B")) {
            MainView.printMainView(scanner);
        }
    }

    public static void getStations(Scanner scanner) {
        System.out.println(PATH_ASK_START);

        System.out.println(PATH_ASK_DESTINATION);
    }
}
