package subway.controller.functioncontroller;

import subway.validator.RouteFindValidation;
import subway.view.InputView;
import subway.view.routefindoutput.RouteFindOutputView;

import java.util.Scanner;

public class RouteFindController extends FunctionController {
    private static final String SHORTEST_DISTANCE = "1";
    private static final String SHORTEST_TIME = "2";
    private static final String BACK = "B";
    private static final String INVALID_INPUT = "";

    public static void start(Scanner scanner) {
        runRouteFindController(scanner);
    }

    private static void runRouteFindController(Scanner scanner) {
        String userChoice = "";
        boolean routeFindControllerDone = false;
        while (!routeFindControllerDone) {
            RouteFindOutputView.printOption();
            userChoice = getUserChoice(scanner);
            routeFindControllerDone = startChosenRouteFindFunction(userChoice, scanner);
        }
    }

    private static String getUserChoice(Scanner scanner) {
        String userChoice = null;
        boolean validChoice = false;
        while (!validChoice) {
            RouteFindOutputView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            validChoice = RouteFindValidation.checkControllerInput(userChoice);
        }
        return userChoice;
    }

    private static boolean startChosenRouteFindFunction(String userChoice, Scanner scanner) {
        if (userChoice.equals(SHORTEST_DISTANCE)) {
            return findShortestDistance(scanner);
        }
        if (userChoice.equals(SHORTEST_TIME)) {
            return findShortestTime(scanner);
        }
        if (userChoice.equals(BACK)) {
            return true;
        }
        return false;
    }

    private static boolean findShortestDistance(Scanner scanner) {
        return true;
    }

    private static boolean findShortestTime(Scanner scanner) {
        return true;
    }
}
