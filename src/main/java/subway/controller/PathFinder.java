package subway.controller;

import subway.view.OutputView;

import java.util.Scanner;

public class PathFinder {
    private final Scanner scanner;

    public PathFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String userInput = askValidMenuNumber();
    }

    private String askValidMenuNumber() {
        OutputView.pathfiner();
        return null;
    }
}
