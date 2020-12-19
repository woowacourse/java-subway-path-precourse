package subway.view;

import subway.util.Validator;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getFunctionSelect(List<String> buttons) {
        OutputView.printFunctionSelectQuery();
        try {
            String input = scanner.nextLine();
            System.out.println();
            Validator.functionSelect(buttons, input);
            return input;
        } catch (IllegalArgumentException IAE) {
            return getFunctionSelect(buttons);
        }
    }

    public String getSourceStation() {
        OutputView.printSourceStationQuery();
        try {
            String input = scanner.nextLine();
            OutputView.printEmptyLine();
            Validator.existStation(input);
            return input;
        } catch (IllegalArgumentException IAE) {
            return getSourceStation();
        }
    }

    public String getDestinationStation() {
        OutputView.printDestinationStationQuery();
        try {
            String input = scanner.nextLine();
            OutputView.printEmptyLine();
            Validator.existStation(input);
            return input;
        } catch (IllegalArgumentException IAE) {
            return getDestinationStation();
        }
    }
}
