package subway.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;
import utils.LineUtils;

public class MainController {
    private static final List<String> EXIT_SIGN = Arrays.asList("q", "Q");
    private static final int START = 1;
    private static final int MENU_END = 1;

    private MainController() {
    }

    public static void runSubwayPath(Scanner scanner) {
        String selection;
        do {
            OutputView.printMainMenu();
            selection = InputView.inputSelection(scanner);
            executeSelection(selection);
        } while (!EXIT_SIGN.contains(selection));
    }

    private static void executeSelection(String selection) {
        try {
            int selectedNumber = Integer.parseInt(selection);
            if (START > selectedNumber || selectedNumber > MENU_END){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            if (EXIT_SIGN.contains(selection)) {
                return;
            }
            System.out.println(LineUtils.ERROR_INVALID_TYPE);
        }
    }
}
