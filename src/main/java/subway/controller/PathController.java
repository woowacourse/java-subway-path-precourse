package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.PathFunction;
import subway.view.resource.Screen;

import java.util.Scanner;

public class PathController {
    private PathController() {
    }

    public static void run(Scanner scanner) {
        OutputView.loadView(Screen.PATH);
        callFunction(InputView.getInputFunctionCode(scanner, Screen.PATH), scanner);
    }

    private static void callFunction(String functionCode, Scanner scanner) {
        if (functionCode.equals(PathFunction.SHORTEST_PATH)) {
            ShortestPathController.run(scanner);
        }
        if (functionCode.equals(PathFunction.MINIMUM_TIME)) {
            MinimumTimePathController.run(scanner);
        }
        if (functionCode.equals(PathFunction.BACK)) {
            ScreenController.run(Screen.MAIN, scanner);
        }
    }
}
