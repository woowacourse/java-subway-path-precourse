package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class RouteController {
    private static final int SHORTEST_LENGTH = 1;
    private static final int SHORTEST_TIME = 2;
    private final int START = 1;
    private final int END = 2;
    private final Scanner scanner;

    public RouteController(Scanner scanner) {
        this.scanner = scanner;
        OutputView.routePage();
        operation(InputView.inputOperationNumber(scanner, START,END));
    }

    private void operation(int operationNumber) {
        if(operationNumber == -1){
            operation(InputView.inputOperationNumber(scanner,START,END));
            return;
        }
        if(operationNumber == SHORTEST_LENGTH){
            shortestLength();
            return;
        }
        if(operationNumber == SHORTEST_TIME){
            shortestTime();
        }
    }

    private void shortestTime() {
    }

    private void shortestLength() {
    }


}
