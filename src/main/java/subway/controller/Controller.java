package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class Controller {

    private final Scanner scanner;
    public Controller(Scanner scanner){
        this.scanner = scanner;
        mainPage();
    }

    private void mainPage() {
        OutputView.mainPage();
        operation(InputView.inputOperationNumber(scanner));
    }

    private void operation(int operationNumber){
        if(operationNumber == -1){
            operation(InputView.inputOperationNumber(scanner));
            return;
        }
        if(operationNumber == 1){

            return;
        }
    }
}
