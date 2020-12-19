package subway.controller;

import subway.Exception.CustomException;
import subway.view.InputView;

import java.util.Scanner;

public class FastestPathFinder {
    public static final String PREFIX_START_STATION = "start";
    private static final String PREFIX_END_STATION = "end";
    private final Scanner scanner;

    public FastestPathFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String startStation = askValidStation(PREFIX_START_STATION);
        String endStation = askValidStation(PREFIX_END_STATION);
        System.out.println(startStation + endStation);
    }

    private String askValidStation(String stationPrefix) {
        try {
            return InputView.askStation(scanner, stationPrefix);
        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
            return askValidStation(stationPrefix);
        }
    }

}
