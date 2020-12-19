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

    public String getSelectedServiceInput() {
        return userInputString();
    }

    public String getSelectedFunctionInput() {
        return userInputString();
    }
}
