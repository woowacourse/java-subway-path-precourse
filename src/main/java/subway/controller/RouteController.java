package subway.controller;

import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class RouteController {
    private static final int SHORTEST_LENGTH = 1;
    private static final int SHORTEST_TIME = 2;
    private static final int ERROR = -1;
    private final int START = 1;
    private final int END = 2;
    private static final String ERROR_MESSAGE = "ERROR";
    private final Scanner scanner;

    public RouteController(Scanner scanner) {
        this.scanner = scanner;
        OutputView.routePage();
        operation(InputView.inputOperationNumber(scanner, START, END));
    }

    private void operation(int operationNumber) {
        if (operationNumber == ERROR) {
            operation(InputView.inputOperationNumber(scanner, START, END));
        }
        if (operationNumber == SHORTEST_LENGTH) {
            shortestLength();
        }
        if (operationNumber == SHORTEST_TIME) {
            shortestTime();
        }
    }

    private void shortestTime() {
        String startStation = InputView.writeStartStation(scanner);
        if (startStation.equals(ERROR_MESSAGE)) {
            new RouteController(scanner);
            return;
        }
        String endStation = InputView.writeEndStation(scanner, startStation);
        if (endStation.equals(ERROR_MESSAGE)) {
            new RouteController(scanner);
            return;
        }
        if (!LineRepository.findShortestTime(startStation, endStation)) {
            new RouteController(scanner);
            return;
        }
        new Controller(scanner);
    }

    private void shortestLength() {
        String startStation = InputView.writeStartStation(scanner);
        if (startStation.equals(ERROR_MESSAGE)) {
            new RouteController(scanner);
            return;
        }
        String endStation = InputView.writeEndStation(scanner, startStation);
        if (endStation.equals(ERROR_MESSAGE)) {
            new RouteController(scanner);
            return;
        }
        if (!LineRepository.findShortestLength(startStation, endStation)) {
            new RouteController(scanner);
            return;
        }
        new Controller(scanner);
    }
}
