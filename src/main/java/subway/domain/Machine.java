package subway.domain;

import java.util.Scanner;
import subway.domain.function.MainFunction;
import subway.view.InputView;
import subway.view.OutputView;

public class Machine {
    public void start(Scanner scanner) {
        try {
            OutputView.printMainMenu();
            MainFunction mainFunction = getInputFunction(scanner);
            if (mainFunction == MainFunction.QUIT) {
                return;
            }
            mainFunction.operate(scanner);
            start(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            OutputView.printEmptyLine();
            start(scanner);
        }
    }

    private MainFunction getInputFunction(Scanner scanner) {
        String functionNumber = InputView.inputFunctionNumber(scanner);
        return MainFunction.getMainFunctionByNumber(functionNumber);
    }
}
