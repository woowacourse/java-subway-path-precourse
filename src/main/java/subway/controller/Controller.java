package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Controller {
    private final int START = 1;
    private final int END = 1;
    private final Scanner scanner;
    public Controller(Scanner scanner){
        this.scanner = scanner;
        mainPage();
    }

    private void mainPage() {
        OutputView.mainPage();
        operation(InputView.inputOperationNumber(scanner,START,END));
    }

    private void operation(int operationNumber){
        if(operationNumber == -1){
            operation(InputView.inputOperationNumber(scanner,START,END));
            return;
        }
        if(operationNumber == 1){
            new RouteController(scanner);
            return;
        }
    }
}
