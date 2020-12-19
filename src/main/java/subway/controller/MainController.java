package subway.controller;

import subway.controller.functioncontroller.RouteFindController;
import subway.validator.MainValidation;
import subway.view.InputView;
import subway.view.mainoutput.MainOutputView;

import java.util.Scanner;

public class MainController {
    private static final String FIND_ROUTE = "1";
    private static final String QUIT = "Q";

    public void start(Scanner scanner) {
        InitialSetupController.initialSetup();
        runMainController(scanner);
    }

    private void runMainController(Scanner scanner) {
        String userChoice = "";
        while (!userChoice.equals(QUIT)) {
            MainOutputView.printOption();
            userChoice = getUserChoice(scanner);
            startChosenController(userChoice, scanner);
        }
    }

    private String getUserChoice(Scanner scanner) {
        String userChoice = null;
        boolean validChoice = false;
        while (!validChoice) {
            MainOutputView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            validChoice = MainValidation.checkControllerInput(userChoice);
        }
        return userChoice;
    }

    private void startChosenController(String userChoice, Scanner scanner) {
        if (userChoice.equals(FIND_ROUTE)) {
            RouteFindController.start(scanner);
        }
    }
}
