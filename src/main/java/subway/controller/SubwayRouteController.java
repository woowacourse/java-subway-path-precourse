package subway.controller;

import subway.utils.InputValidation;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayRouteController {
    private static final String SHORTEST_DIST = "1";
    private static final String MIN_TIME = "2";
    private static final String BACK = "B";

    public static final void logic(Scanner scanner) {
        OutputView.printRouteMainMenu();
        try {
            String functionNumber = InputValidation.isValidOfInputRouteMenu(InputView.inputFunctionNumber(scanner));
            if (functionNumber.equals(BACK)) return;
            MenuConnectByCommand(functionNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static final void MenuConnectByCommand(String command) {
        if (command.equals(SHORTEST_DIST)) {
            lookupShortestDistancePath();
            return;
        }
        if (command.equals(MIN_TIME)) {
            lookupMinTimePath();
            return;
        }
    }

    private static final void lookupShortestDistancePath() {
        System.out.println("최단 거리");
    }

    private static final void lookupMinTimePath() {
        System.out.println("최소 시간");
    }
}
