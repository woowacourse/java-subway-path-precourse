package subway;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        executeSystem(scanner);
    }

    private static void executeSystem(Scanner scanner) {
        do {
            executeOrder(scanner);
        } while (Status.isContinue());
    }

    private static void executeOrder(Scanner scanner) {
        try {
            String command = InputView.inputFunction(scanner);
            FunctionMapper.matchMainFunction(FunctionMapper.MAIN_FUNCTION_MAPPER, command);
        } catch (Exception exception) {
            OutputView.printError(exception.getMessage());
        }
    }
}
