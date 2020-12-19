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
            chooseOption(pathInput, scanner);
        }
    }

    public static String getPathInput(Scanner scanner) {
        OutputView.printPathCriteriaScreen();
        return InputView.scanPathInput(scanner);
    }

    public static boolean isBack(String pathInput) {
        return pathInput.equals(InputType.BACK.getInput());
    }

    public static void chooseOption(String input, Scanner scanner) {
        if (input.equals(InputType.ONE.getInput())) {
            getPathByShortestDistance(scanner);
            return;
        }
        if (input.equals(InputType.TWO.getInput())) {
            getPathByShortestTime(scanner);
            return;
        }
        System.out.println(ExceptionType.INVALID_OPTION_CHOICE.getException());
    }

    public static void getPathByShortestDistance(Scanner scanner) {
        String originInput = InputView.scanOriginInput(scanner);
        System.out.println();
        String destinationInput = InputView.scanDestinationInput(scanner);
        System.out.println();
    }

    public static void getPathByShortestTime(Scanner scanner) {
        String originInput = InputView.scanOriginInput(scanner);
        System.out.println();
        String destinationInput = InputView.scanDestinationInput(scanner);
        System.out.println();
    }
}
