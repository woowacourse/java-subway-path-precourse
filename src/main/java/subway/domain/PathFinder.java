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

    private static void startAndEndStationInput(Scanner scanner) {
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
            int totalTime = getTotalTime(path);
            OutputView.printResult(totalDist, path, totalTime);
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR]" + e.getMessage());
        }
    }

    public static void findShortestTimePath(Scanner scanner) {
        try {
            startAndEndStationInput(scanner);
            int totalTime = DijkstraGraphRepository.getShortestTime(startStationName, endStationName);
            List<String> path = DijkstraGraphRepository.getShortestTimePath(startStationName, endStationName);
            OutputView.printResult(0, path, totalTime);
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR]" + e.getMessage());
        }
    }

    public static String stationNameInput(Scanner scanner) throws IllegalArgumentException {
        String stationName = scanner.nextLine();
        if (!Validator.isValidStation(stationName)) {
            throw new IllegalArgumentException("존재하지 않는 역이름 입니다.");
        }
        return stationName;
    }

    private static int getTotalTime(List<String> path) {
        int totalTime = 0;
        //Map<String, Map<String, Integer>> stationTimeMap = DijkstraGraphRepository.getStationTimeMap();
        for (int i = 0; i < path.size() - 1; ++i) {
            String beforeStation = path.get(i);
            String afterStation = path.get(i + 1);
            //totalTime += DijkstraGraphRepository.stationTimeMap.get(beforeStation).get(afterStation);
            //System.out.println(beforeStation + " " + afterStation);
            //System.out.println(DijkstraGraphRepository.getDist(beforeStation, afterStation));
        }
        return totalTime;
    }
}
