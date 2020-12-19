package subway.view;

import subway.domain.GraphRepository;
import subway.exception.ExceptionManager;

import java.util.Scanner;

public class MainView {
    public static final String MAIN = "## 메인 화면";
    public static final String MAIN_MENU_FIND_PATH = "1. 경로 조회";
    public static final String MAIN_MENU_QUIT = "Q. 종료";

    public static void printMainView(Scanner scanner) {
        String command;
        printMainMenu();
        while(true) {
            try {
                command = Input.getCommand(scanner);
                ExceptionManager.checkMainCommand(command);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ExceptionManager.COMMAND_WRONG);
            }
        }
        generateCommand(command, scanner);
    }

    public static void printMainMenu() {
        System.out.println(MAIN);
        System.out.println(MAIN_MENU_FIND_PATH);
        System.out.println(MAIN_MENU_QUIT);
        System.out.print("\n");
    }

    private static void generateCommand(String command, Scanner scanner) {
        if(command.equals("1")) {
            FindPathView.printFindPathView(scanner);
        }
    }


}
