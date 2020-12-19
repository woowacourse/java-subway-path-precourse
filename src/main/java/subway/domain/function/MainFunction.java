package subway.domain.function;

import java.util.Arrays;
import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;

public enum MainFunction {
    FIND_ROUTE("1") {
        @Override
        public void operate(Scanner scanner) {
            try {
                OutputView.printFindRouteMenu();
                FindRouteFunction function = getInputFunction(scanner);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                OutputView.printEmptyLine();
                operate(scanner);
            }
        }
    },
    QUIT("Q") {
        @Override
        public void operate(Scanner scanner) {
        }
    };

    private String number;

    MainFunction(String number) {
        this.number = number;
    }

    public static MainFunction getMainFunctionByNumber(String inputNumber) {
        return Arrays.stream(MainFunction.values())
            .filter(function -> function.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    private static FindRouteFunction getInputFunction(Scanner scanner) {
        String functionNumber = InputView.inputFunctionNumber(scanner);
        return FindRouteFunction.getFindRouteFunctionByNumber(functionNumber);
    }

    public abstract void operate(Scanner scanner);
}