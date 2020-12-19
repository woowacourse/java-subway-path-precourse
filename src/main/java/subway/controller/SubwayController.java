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
        InitializationService.initializeStations();
        InitializationService.initializeLines();
    }

    public static void startSubway(Scanner scanner) {
        while (true) {
            OutputView.printMainScreen();
            String mainInput = InputView.scanMainInput(scanner);

            if (mainInput.equals(InputType.QUITTING.getInput())) {
                break;
            }

            chooseOption(mainInput, scanner);
        }
    }

    public static void chooseOption(String input, Scanner scanner) {
        if (input.equals(InputType.ONE.getInput())) {
            PathController.startPath(scanner);
            return;
        }
        System.out.println(ExceptionType.INVALID_OPTION_CHOICE.getException());
    }
}
