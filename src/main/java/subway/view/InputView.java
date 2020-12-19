package subway.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String userInput() {
        return scanner.nextLine();
    }
}
