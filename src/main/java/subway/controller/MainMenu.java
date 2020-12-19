package subway.controller;

import subway.Exception.CustomException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainMenu {
    public static final String REGEX_VALID_MAIN_MENU = "[1Qq]";
    public static final String REGEX_QUIT_MENU = "[Qq]";
    public static final String MENU_PATH_FINDER = "1";
    private final Scanner scanner;
    private boolean doNext;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
        this.doNext = true;
    }

    public void run() {
        String userInput = askValidMenuNumber();
        if (userInput.equals(MENU_PATH_FINDER)) {
            PathFinderMenu pathFinderMenu = new PathFinderMenu(scanner);
            pathFinderMenu.run();
        } else if (userInput.matches(REGEX_QUIT_MENU)) {
            this.doNext = false;
        }

    }

    private String askValidMenuNumber() {
        OutputView.mainMenu();
        try {
            return InputView.askMenu(scanner, REGEX_VALID_MAIN_MENU);
        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
            return askValidMenuNumber();
        }
    }

    public boolean doNext() {
        if (doNext) {
            System.out.println();
        }
        return doNext;
    }
}
