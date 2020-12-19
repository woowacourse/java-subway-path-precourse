package subway.view;

import java.util.Scanner;

public class UserInput extends Display{
    private static final String REQUEST_SELECT_MENU = "원하는 기능을 선택하세요.";
    private static Scanner scanner;

    public static String getSelectMenu() {
        printNotice(REQUEST_SELECT_MENU);
        return scanner.nextLine();
    }

    public static void giveScanner(Scanner scanner) {
        UserInput.scanner = scanner;
    }
}
