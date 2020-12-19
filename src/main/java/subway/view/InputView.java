package subway.view;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static String selectMenu(Scanner scanner) {
        OutputView.println("## 원하는 기능을 선택하세요.");
        return getInput(scanner);
    }

    public static String getInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
