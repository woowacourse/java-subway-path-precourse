package subway.view;

import subway.utils.Validator;

import java.util.Scanner;

public class InputView {

    public static String getMainMenu(Scanner scanner) {

        String inputOrder = scanner.nextLine();
        Validator.checkMainInputOrder(inputOrder);
        return inputOrder;

    }

    public static void getPathRuleMenu() {

    }

    public static void getStartingStation() {

    }

    public static void getEndingStation() {

    }

}
