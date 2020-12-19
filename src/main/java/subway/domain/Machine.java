package subway.domain;

import java.util.Scanner;
import subway.utils.StringUtils;
import subway.view.InputView;
import subway.view.OutputView;

public class Machine {
    public void start(Scanner scanner) {
        OutputView.printMain();
        int functionNumber = getInputFunctionNumber(scanner);
    }

    private int getInputFunctionNumber(Scanner scanner) {
        String input = InputView.inputFunctionNumber(scanner);
        int functionNumber = StringUtils.toInt(input);
        return functionNumber;
    }
}
