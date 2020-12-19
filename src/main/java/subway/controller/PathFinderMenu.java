package subway.controller;

import subway.Exception.CustomException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class PathFinderMenu {
    public static final String REGEX_VALID_PATH_FINDER_MENU = "[1-2Bb]";
    public static final String MENU_SHORTEST_PATH_FINDER = "1";
    public static final String MENU_FASTEST_PATH_FINDER = "2";
    private final Scanner scanner;

    public PathFinderMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String userInput = askValidMenuNumber();
        if (userInput.equals(MENU_SHORTEST_PATH_FINDER)) {
            ShortestPathFinder shortestPathFinder = new ShortestPathFinder(scanner);
            shortestPathFinder.run();
        } else if (userInput.equals(MENU_FASTEST_PATH_FINDER)) {
            FastestPathFinder fastestPathFinder = new FastestPathFinder(scanner);
            fastestPathFinder.run();
        }
    }

    private String askValidMenuNumber() {
        OutputView.pathfinderMenu();
        try {
            return InputView.askMenu(scanner, REGEX_VALID_PATH_FINDER_MENU);
        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
            return askValidMenuNumber();
        }
    }
}
