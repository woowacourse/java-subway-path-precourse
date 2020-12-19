package subway.view;

import subway.view.resource.Message;
import subway.view.resource.Screen;
import subway.view.util.InputValidator;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    public static String getInputFunctionCode(Scanner scanner, Screen screen) {
        OutputView.printMessage(Message.REQUEST_FUNCTION_CODE);
        return InputValidator.validateFunctionCode(scanner, scanner.nextLine(), screen);
    }
}
