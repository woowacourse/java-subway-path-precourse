package subway.controller;

import java.util.Scanner;
import subway.exception.ErrorInputException;
import subway.view.Input.InputView;
import subway.view.output.OutputView;

public class InputController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Scanner scanner;

    private InputController(InputView inputView, OutputView outputView, Scanner scanner) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.scanner = scanner;
    }

    public static InputController createInputController(InputView inputView, OutputView outputView, Scanner scanner) {
        return new InputController(inputView, outputView, scanner);
    }

    public String inputMainFunc() {
        while (true) {
            try {
                outputView.printMain();
                outputView.printSelectFunc();
                return inputView.readMainFunc(scanner.next());
            } catch (ErrorInputException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public String inputSelectRoute() {
        while (true) {
            try {
                outputView.printSelectPath();
                outputView.printSelectFunc();
                return inputView.readSelectRoute(scanner.next());
            } catch (ErrorInputException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public String inputStartStation() {
        while (true) {
            try {
                outputView.printStartStation();
                return inputView.readStartStation(scanner.next());
            } catch (ErrorInputException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public String inputEndStation(String start) {
        while (true) {
            try {
                outputView.printEndStation();
                return inputView.readEndStation(start, scanner.next());
            } catch (ErrorInputException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
