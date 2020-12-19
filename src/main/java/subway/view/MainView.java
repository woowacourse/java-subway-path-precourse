package subway.view;

import java.util.Scanner;

public class MainView {
    public static final String MAIN = "## 메인 화면";
    public static final String MAIN_MENU_FIND_PATH = "1. 경로 조회";
    public static final String MAIN_MENU_QUIT = "Q. 종료";
    public static final String MAIN_ASK_COMMAND = " ## 원하는 기능을 선택하세요.";

    public static void printMainView(Scanner scanner) {
        printMainMenu();
        String command = Input.getInput(scanner);
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
