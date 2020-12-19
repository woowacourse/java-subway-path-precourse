package subway.controller;

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
        this.doNext = false;
    }

    private void askValidMenuNumber() {
        OutputView.mainMenu();
    }

    public boolean doNext() {
        if (doNext) {
            System.out.println();
        }
        return doNext;
    }
}
