package subway.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scan() {
        return scanner.nextLine();
    }
}
