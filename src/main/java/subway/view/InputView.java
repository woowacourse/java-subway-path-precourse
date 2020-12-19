package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_FUNCTION = "원하는 기능을 선택해 주세요.";

    private InputView() {
    }

    public static String inputFunction(Scanner scanner) {
        OutputView.printGuide(SELECT_FUNCTION);
        return scanner.nextLine();
    }
}
