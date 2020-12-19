package subway.view;

import java.util.Scanner;

public class MainOutput {
    public static final String MAIN = "## 메인 화면";
    public static final String MAIN_MENU_FIND_PATH = "1. 경로 조회";
    public static final String MAIN_MENU_QUIT = "Q. 종료";
    public static final String MAIN_ASK = " ## 원하는 기능을 선택하세요.";

    public static void printMainMenu() {
        System.out.println(MAIN);
        System.out.println(MAIN_MENU_FIND_PATH);
        System.out.println(MAIN_MENU_QUIT);
        System.out.print("\n");
    }

    public void getCommand(Scanner scanner) {
        System.out.println(MAIN_ASK);
        String command = MainInput.getInput(scanner);
    }

    private void generateCommand(String input) {
        if(input == "1") {

        }
        if(input == "Q") {

        }
    }


}
