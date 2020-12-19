package subway.domain;

import subway.domain.repositories.DijkstraGraphRepository;
import subway.utils.Validator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
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
        try {
            startAndEndStationInput(scanner);
            int totalDist = DijkstraGraphRepository.getShortestDist(startStationName, endStationName);
            List<String> path = DijkstraGraphRepository.getShortestDistPath(startStationName, endStationName);
            OutputView.printResult(totalDist, path);
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR]" + e.getMessage());
        }
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
