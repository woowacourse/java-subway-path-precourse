package subway.view;

import subway.util.Validator;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getFunctionSelect(List<String> buttons) {
        OutputView.printFunctionSelectQuery();
        try {
            String input = scanner.nextLine();
            System.out.println();
            Validator.functionSelect(buttons, input);
            return input;
        } catch (IllegalArgumentException e) {
            return getFunctionSelect(buttons);
        }
    }
}
