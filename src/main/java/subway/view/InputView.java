package subway.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    private static String ENTER_FUNCTION_INPUT = "## 원하는 기능을 선택하세요.";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputFunction() {
        System.out.println(ENTER_FUNCTION_INPUT);
        return scanner.nextLine();
    }
}
