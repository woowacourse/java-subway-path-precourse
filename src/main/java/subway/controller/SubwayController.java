package subway.controller;

import subway.service.InitializationService;
import subway.type.ExceptionType;
import subway.type.InputType;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    public static void runSubway(Scanner scanner) {
        initializeSubway();
        startSubway(scanner);
    }

    public static void initializeSubway() {
        InitializationService.initializeStation();
        InitializationService.initializeLine();
    }

    public static void startSubway(Scanner scanner) {
        while (true) {
            String mainInput = getMainInput(scanner);
            System.out.println();

            if (isQuitting(mainInput)) {
                break;
            }
            chooseOption(mainInput, scanner);
        }
    }

    public static String getMainInput(Scanner scanner) {
        OutputView.printMainScreen();
        return InputView.scanMainInput(scanner);
    }

    public static boolean isQuitting(String mainInput) {
        return mainInput.equals(InputType.QUITTING.getInput());
    }

    public static void chooseOption(String input, Scanner scanner) {
        if (input.equals(InputType.ONE.getInput())) {
            PathController.startPath(scanner);
            return;
        }
        System.out.println(ExceptionType.INVALID_OPTION_CHOICE.getException());
    }
}
