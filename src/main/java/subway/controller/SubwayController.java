package subway.controller;

import subway.utils.InputValidation;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    private static final String EXIT = "Q";

    public static final void run(Scanner scanner) {
        while (true) {
            OutputView.printMainMenu();
            try {
                String functionNumber = InputValidation.isValidOfInputMainMenu(InputView.inputFunctionNumber(scanner));
                if (functionNumber.toUpperCase().equals(EXIT)) {
                    break;
                }
                SubwayRouteController.logic(scanner);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
