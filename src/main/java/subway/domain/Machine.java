package subway.domain;

import java.util.Scanner;
import subway.domain.function.MainFunction;
import subway.view.InputView;
import subway.view.OutputView;

public class Machine {
    public void start(Scanner scanner) {
        OutputView.printMainMenu();
        MainFunction mainFunction = getInputFunction(scanner);
        if (mainFunction == MainFunction.QUIT) {
            return;
        }
        mainFunction.operate(scanner);
        start(scanner);
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
