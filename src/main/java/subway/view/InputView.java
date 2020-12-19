package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String OPTION_SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputMainMenuOption() {
        System.out.println(OPTION_SELECT_MESSAGE);
        return scanner.nextLine();
    }
}
