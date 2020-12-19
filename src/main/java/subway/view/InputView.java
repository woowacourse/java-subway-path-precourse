package subway.view;

import java.util.Scanner;

public class InputView {
    public static final String PLEASE_SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";

    private static Scanner scanner;

    private InputView() {}

    public static void init(Scanner scanner) {
        if (InputView.scanner == null) {
            InputView.scanner = scanner;
        }
    }

    public static String print(String message) {
        OutputView.printNewLine();
        System.out.println(message);
        return InputView.scanner.nextLine();
    }
}
