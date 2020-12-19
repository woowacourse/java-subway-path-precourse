package subway.controller;

import subway.service.PathService;
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
            PathService.getPathByShortestDistance(scanner);
            return;
        }
        if (input.equals(InputType.TWO.getInput())) {
            PathService.getPathByShortestTime(scanner);
            return;
        }
        System.out.println(ExceptionType.INVALID_OPTION_CHOICE.getException());
    }
}
