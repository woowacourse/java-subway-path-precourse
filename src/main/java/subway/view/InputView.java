package subway.view;

import subway.controller.SubwayController;

import java.util.Scanner;

import static subway.view.OutputView.printQuestion;

public class InputView {
    private static Scanner scanner = SubwayController.scanner;

    public static String inputFunction() {
        printQuestion(TextCollection.SELECT_FUNCTION_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputValue() {
        return scanner.nextLine();
    }
}
