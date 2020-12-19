package subway.console;

import java.util.Scanner;

public class Input {
    private static final String MESSAGE_SELECT_MENU = "\n## 원하는 기능을 선택하세요.";
    static Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String getMainScreenInput() {
        System.out.println(MESSAGE_SELECT_MENU);
        return scanner.nextLine();
    }

    public static String getPathCriteriaScreenInput() {
        System.out.println(MESSAGE_SELECT_MENU);
        return scanner.nextLine();
    }
}
