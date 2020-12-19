package subway.controller;

import java.util.Scanner;
import subway.controller.constants.SelectOptionConstants;
import subway.view.PathInputView;

public class PathManager {
    private Scanner scanner;

    public PathManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processSet() {
        boolean happenedError;
        do {
            PathInputView.askPathScreen();
            happenedError = checkSectorStatus();
        } while (happenedError);
    }

    private boolean checkSectorStatus() {
        try {
            String unit = scanner.nextLine();
            isValidUnit(unit);
            goUnit(scanner, unit);
            return false;
        } catch (Exception error) {
            return true;
        }
    }

    private void isValidUnit(String unit) {
        if (!SelectOptionConstants.PATH.contains(unit)) {
            System.out.println();
            System.out.println(SelectOptionConstants.OPTION_ERROR);
            throw new IllegalArgumentException(SelectOptionConstants.OPTION_ERROR);
        }
    }

    private void goUnit(Scanner scanner, String unit) {
        for (PathOption optionOnPath : PathOption.values()) {
            filterUnit(optionOnPath, scanner, unit);
        }
    }

    private void filterUnit(PathOption candidate, Scanner scanner, String unit) {
        if (candidate.getOption().equals(unit)) {
            candidate.processUnit(scanner);
        }
    }
}
