package subway.controller;

import subway.Exception.CustomException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class PathFinder {
    public static final String REGEX_VALID_PATH_FINDER_MENU = "[1-2Bb]";
    private final Scanner scanner;

    public PathFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String userInput = askValidMenuNumber();
    }

    private String askValidMenuNumber() {
        OutputView.pathfiner();
        try {
            return InputView.askMenu(scanner, REGEX_VALID_PATH_FINDER_MENU);
        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
            return askValidMenuNumber();
        }
    }
}
