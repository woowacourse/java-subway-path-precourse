package subway.view;

import java.util.Scanner;

public class MainMenu {
    private final String MAIN_TITLE = "## 메인 화면";
    private final String MAINMENU_1 = "1. 경로 조회";
    private final String QUIT_APP = "Q. 종료";
    private final String ENTER = "\n";
    private final String CHOICE_MENU = "## 원하는 기능을 선택하세요.";
    private final String QUIT_MESSAGE = "프로그램을 종료합니다.";

    private Scanner scanner;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startMainMENU() {
        outputMainMenu();
        String input = scanner.nextLine();
        System.out.println();
        inputMenu(input);
    }

    private void outputMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(MAIN_TITLE).append(ENTER)
                .append(MAINMENU_1).append(ENTER)
                .append(QUIT_APP).append(ENTER)
                .append(ENTER)
                .append(CHOICE_MENU);
    }

    private void inputMenu(String input) {
        while (true) {
            if (input.equals("1")) {

            }
            if (input.equals("Q")) {
                System.out.println();
                System.out.println(QUIT_MESSAGE);
                return;
            }
        }
    }
}
