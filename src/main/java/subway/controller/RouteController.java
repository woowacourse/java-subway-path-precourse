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
    private final int START_STATION = 0;
    private final int END_STATION = 1;
    private final int STATIONS_SIZE = 2;
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
        String[] stations = stationInfo();
        if(stations[START_STATION] == null || stations[END_STATION] == null){
            new RouteController(scanner);
            return;
        }
        if (!LineRepository.findShortestTime(stations[START_STATION], stations[END_STATION])) {
            new RouteController(scanner);
            return;
        }
        new Controller(scanner);
    }

    private void shortestLength() {
        String[] stations = stationInfo();
        if(stations[START_STATION] == null || stations[END_STATION] == null){
            new RouteController(scanner);
            return;
        }
        if (!LineRepository.findShortestLength(stations[START_STATION], stations[END_STATION])) {
            new RouteController(scanner);
            return;
        }
        new Controller(scanner);
    }

    private String[] stationInfo(){
        String[] stations = new String[STATIONS_SIZE];
        String startStation = InputView.writeStartStation(scanner);
        if (startStation.equals(ERROR_MESSAGE)) {
            new RouteController(scanner);
            return stations;
        }
        String endStation = InputView.writeEndStation(scanner, startStation);
        if (endStation.equals(ERROR_MESSAGE)) {
            new RouteController(scanner);
            return stations;
        }
        stations[START_STATION] = startStation;
        stations[END_STATION] = endStation;
        return stations;
    }
}
