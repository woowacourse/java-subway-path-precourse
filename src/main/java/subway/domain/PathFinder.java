package subway.domain;

import subway.utils.Validator;
import subway.view.InputView;

import java.util.Scanner;

public class PathFinder {
    private static String startStationName;
    private static String endStationName;
    public static void startAndEndStationInput(Scanner scanner) {
        try {
            InputView.printStartStationInput();
            startStationName = stationNameInput(scanner);
            InputView.printEndStationInput();
            endStationName = stationNameInput(scanner);
            Validator.sameStationNameCheck(startStationName, endStationName);
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR]" + e.getMessage());
        }
    }

    public static void findShortestDistPath(Scanner scanner) {
        startAndEndStationInput(scanner);
    }

    public static void findShortestTimePath(Scanner scanner) {
        startAndEndStationInput(scanner);
    }

    public static String stationNameInput(Scanner scanner) throws IllegalArgumentException {
        String stationName = scanner.nextLine();
        if (!Validator.isValidStation(stationName)) {
            throw new IllegalArgumentException("존재하지 않는 역이름 입니다.");
        }
        return stationName;
    }
}
