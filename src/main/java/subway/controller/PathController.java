package subway.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.PathType;
import subway.service.PathService;
import subway.view.InputView;
import subway.view.OutputView;
import utils.LineUtils;

public class PathController {
    private static final List<String> EXIT_SIGN = Arrays.asList("b", "B");

    private PathController() {
    }

    public static void pathSearch(Scanner scanner) {
        OutputView.printMenu(LineUtils.PATH_MENU);
        String selection = InputView.inputSelection(scanner);
        executeSelection(selection);
    }

    private static void executeSelection(String selection) {
        if (EXIT_SIGN.contains(selection)) {
            return;
        }
        if (Integer.parseInt(selection) == PathType.DISTANCE.getNumber()) {
            PathService.shortestDistancePath();
        }
        if (Integer.parseInt(selection) == PathType.TIME.getNumber()) {
            PathService.shortestTimePath();
        }
    }
}
