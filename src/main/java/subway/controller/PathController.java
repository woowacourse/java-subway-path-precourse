package subway.controller;

import subway.type.ExceptionType;
import subway.type.InputType;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class PathController {
    public static void startPath(Scanner scanner) {
        while (true) {
            OutputView.printPathCriteriaScreen();
            String pathInput = InputView.scanPathInput(scanner);

            if (pathInput.equals(InputType.BACK.getInput())) {
                return;
            }
            chooseOption(pathInput);
        }
    }

    public static void chooseOption(String input) {
        if (input.equals(InputType.ONE.getInput())) {
            return;
        }
        if (input.equals(InputType.TWO.getInput())) {
            return;
        }
        System.out.println(ExceptionType.INVALID_OPTION_CHOICE.getException());
    }
}
