package subway.view;

import subway.exception.ExceptionManager;
import subway.util.GraphInitializer;

import java.util.Scanner;

public class FindPathView {
    public static final String PATH = "## 경로 기준";
    public static final String PATH_MENU_DISTANCE = "1. 최단 거리";
    public static final String PATH_MENU_TIME = "2. 최소 시간";
    public static final String PATH_MENU_BACK = "B. 돌아가기";

    public static void printFindPathView(Scanner scanner) {
        String command;
        printPathMenu();
        while(true) {
            try {
                command = Input.getCommand(scanner);
                ExceptionManager.checkPathCommand(command);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ExceptionManager.COMMAND_WRONG);
            }
        }
        generateCommand(command, scanner);
    }

    private static void printPathMenu() {
        System.out.println(PATH);
        System.out.println(PATH_MENU_DISTANCE);
        System.out.println(PATH_MENU_TIME);
        System.out.println(PATH_MENU_BACK);
    }

    public static void generateCommand(String command, Scanner scanner) {
        if(command.equals("1") || command.equals("2")) {
            new GraphInitializer(command, scanner);
            return;
        }

        if(command.equals("B")) {
            MainView.printMainView(scanner);
        }
    }
}
