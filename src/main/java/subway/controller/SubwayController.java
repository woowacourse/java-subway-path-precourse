package subway.controller;

import subway.utils.InputValidation;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    public static void run(Scanner scanner) {
        while (true) {
            OutputView.printMainMenu();
            try {
                String functionNumber = InputValidation.isValidOfInputMainMenu(InputView.inputFunctionNumber(scanner));
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
