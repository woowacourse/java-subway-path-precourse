package subway.view;

import subway.utils.Validator;

import java.util.Scanner;

public class InputView {

    public static String getMainMenu(Scanner scanner) {

        String inputOrder = scanner.nextLine();
        Validator.checkMainInputOrder(inputOrder);
        return inputOrder;

    }

    public static String getPathRuleMenu(Scanner scanner) {
        String inputOrder = scanner.nextLine();
        Validator.checkPathRuleInputOrder(inputOrder);
        return inputOrder;
    }

    public static String getStationName(Scanner scanner) {
        String inputOrder = scanner.nextLine();
        Validator.checkValidStation(inputOrder);
        return inputOrder;
    }
}
