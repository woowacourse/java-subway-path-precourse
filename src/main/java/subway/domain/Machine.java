package subway.domain;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;

public class Machine {
    public void start(Scanner scanner) {
        OutputView.printMain();
        MainFunction mainFunction = getInputFunction(scanner);
        mainFunction.operate();
    }

    private MainFunction getInputFunction(Scanner scanner) {
        try {
            String functionNumber = InputView.inputFunctionNumber(scanner);
            return MainFunction.getMainFunctionByNumber(functionNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            OutputView.printEmptyLine();
            return getInputFunction(scanner);
        }
    }
}
