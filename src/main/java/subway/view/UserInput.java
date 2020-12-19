package subway.view;

import java.util.Scanner;

public class UserInput extends Display{
    private static final String REQUEST_SELECT_MENU = "원하는 기능을 선택하세요.";
    private static final String REQUEST_SOURCE_NAME = "출발역을 입력하세요.";
    private static final String REQUEST_DESTINATION_NAME = "도착역을 입력하세요.";
    private static Scanner scanner;

    public static void giveScanner(Scanner scanner) {
        UserInput.scanner = scanner;
    }

    public static String getSelectMenu() {
        printNotice(REQUEST_SELECT_MENU);
        return scanner.nextLine();
    }

    public static String getSourceName() {
        printNotice(REQUEST_SOURCE_NAME);
        return scanner.nextLine();
    }

    public static String getDesitnationName() {
        printNotice(REQUEST_DESTINATION_NAME);
        return scanner.nextLine();
    }
}
