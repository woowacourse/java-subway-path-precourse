package subway.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }


    private String userInputString() {
        return scanner.nextLine();
    }

    public String getSelectedFunctionInput() {
        return userInputString();
    }

    public String getSelectedBasisInput() {
        return userInputString();
    }
}
