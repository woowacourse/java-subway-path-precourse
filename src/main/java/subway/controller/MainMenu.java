package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainMenu {
    public static final String REGEX_VALID_MENU_CHARACTER = "[1-2Qq]";
    private final Scanner scanner;
    private boolean doNext;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
        this.doNext = true;
    }

    public void run() {
        askValidMenuNumber();
    }

    private String askValidMenuNumber() {
        OutputView.mainMenu();
        return InputView.askMenu(scanner, REGEX_VALID_MENU_CHARACTER);
    }

    public boolean doNext() {
        if (doNext) {
            System.out.println();
        }
        return doNext;
    }
}
