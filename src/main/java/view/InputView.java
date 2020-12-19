package view;

import java.util.Scanner;

public class InputView {
    public static final String SELECT_YOUR_CHOICE = "## 원하는 기능을 선택하세요.";
    final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputChoice() {
        System.out.println(SELECT_YOUR_CHOICE);
        return scanner.next();
    }
}
