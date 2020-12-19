package subway.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scanMenu() {
        OutputView.printSelectMessage();
        return getInput();
    }

    public String scanStartStation() {
        OutputView.printStartInputMessage();
        return getInput();
    }

    public String scanEndStation() {
        OutputView.printEndInputMessage();
        return getInput();
    }

    private String getInput() {
        return scanner.nextLine();
    }
}
