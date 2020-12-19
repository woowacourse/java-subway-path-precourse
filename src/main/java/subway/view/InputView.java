package subway.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private String scanMenu() {
        OutputView.printSelectMessage();
        return getInput();
    }

    private String getInput() {
        return scanner.nextLine();
    }
}
