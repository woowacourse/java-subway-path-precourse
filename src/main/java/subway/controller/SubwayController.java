package subway.controller;

import subway.service.initialization.SubwayInitialization;
import subway.type.ExceptionType;
import subway.type.InputType;
import subway.view.InputView;

import java.util.Scanner;

public class SubwayController implements OptionInterface {
    public static void runSubway(Scanner scanner) {
        initializeSubway();
        startSubway(scanner);
    }

    public static void initializeSubway() {
        SubwayInitialization.initializeStation();
        SubwayInitialization.initializeLine();
        SubwayInitialization.initializeStations();
        SubwayInitialization.initializeMaps();
    }

    public static void startSubway(Scanner scanner) {
        SubwayController subwayController = new SubwayController();

        while (true) {
            String mainInput = InputView.scanMainInput(scanner);
            System.out.println();

            if (isQuitting(mainInput)) {
                break;
            }
            subwayController.chooseOption(mainInput, scanner);
        }
    }

    public static boolean isQuitting(String mainInput) {
        return mainInput.equals(InputType.QUITTING.getInput());
    }

    @Override
    public void chooseOption(String input, Scanner scanner) {
        if (input.equals(InputType.ONE.getInput())) {
            PathController.startPath(scanner);
            return;
        }
        System.out.println(ExceptionType.INVALID_OPTION_CHOICE.getException());
    }
}
