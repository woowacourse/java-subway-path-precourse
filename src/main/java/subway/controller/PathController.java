package subway.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.Path;
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
        executeSelection(scanner, selection);
    }

    private static void executeSelection(Scanner scanner, String selection) {
        if (EXIT_SIGN.contains(selection)) {
            return;
        }
        if (Integer.parseInt(selection) == PathType.DISTANCE.getNumber()) {
            Path path = PathService.shortestDistancePath(scanner);
            System.out.println(path.getDistance());
        }
        if (Integer.parseInt(selection) == PathType.TIME.getNumber()) {
            PathService.shortestTimePath();
        }
    }
}
