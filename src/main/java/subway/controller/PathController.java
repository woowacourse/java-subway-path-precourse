package subway.controller;

import subway.type.ExceptionType;
import subway.type.InputType;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class PathController {
    public static void startPath(Scanner scanner) {
        while (true) {
            String pathInput = getPathInput(scanner);
            System.out.println();

            if (isBack(pathInput)) {
                return;
            }
            chooseOption(pathInput);
        }
    }

    public static String getPathInput(Scanner scanner) {
        OutputView.printPathCriteriaScreen();
        return InputView.scanPathInput(scanner);
    }

    public static boolean isBack(String pathInput) {
        return pathInput.equals(InputType.BACK.getInput());
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
