package subway.controller;

import subway.controller.validation.PathValidation;
import subway.type.ExceptionType;
import subway.type.InputType;
import subway.view.InputView;

import java.util.Scanner;

public class PathController implements OptionInterface {
    public static void startPath(Scanner scanner) {
        PathController pathController = new PathController();

        while (true) {
            String pathInput = InputView.scanPathInput(scanner);
            System.out.println();

            if (isBack(pathInput)) {
                return;
            }
            pathController.chooseOption(pathInput, scanner);
        }
    }

    public static boolean isBack(String pathInput) {
        return pathInput.equals(InputType.BACK.getInput());
    }

    @Override
    public void chooseOption(String input, Scanner scanner) {
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

        PathValidation.isValidStations(originInput, destinationInput);
    }

    public static void getPathByShortestTime(Scanner scanner) {
        String originInput = InputView.scanOriginInput(scanner);
        System.out.println();
        String destinationInput = InputView.scanDestinationInput(scanner);
        System.out.println();

        PathValidation.isValidStations(originInput, destinationInput);
    }
}
