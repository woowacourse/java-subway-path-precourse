package subway.view;

import java.util.Scanner;

public class InputView {

    private static final String CHOOSE_FUNCTION = "## 원하는 기능을 선택하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputFunction() {
        return userStringInput(CHOOSE_FUNCTION);
    }

    private String userStringInput(String specificInfo) {
        System.out.println();
        System.out.println(specificInfo);
        return scanner.nextLine().trim();
    }
}
