package subway;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;

public class PathCalculator {

    public static void start(Scanner scanner, PathCriteriaSelectionType criteriaType) {
        Station startStation = getInputStartStation(scanner);
        Station endStation = getInputEndStation(scanner);
        calculate(startStation, endStation, criteriaType);
    }

    private static Station getInputEndStation(Scanner scanner) {
        PathCalculatorPrinter.printEndStationUserInputMessage();
        String endStationName = scanner.nextLine();
        return StationRepository.findByName(endStationName);
    }

    private static Station getInputStartStation(Scanner scanner) {
        PathCalculatorPrinter.printStartStationUserInputMessage();
        String startStationName = scanner.nextLine();
        return StationRepository.findByName(startStationName);
    }

    private static void calculate(Station startStation, Station endStation,
        PathCriteriaSelectionType criteriaType) {
        if (criteriaType == PathCriteriaSelectionType.SHORTEST_DISTANCE) {
            calculateShortestDistancePath(startStation, endStation);
        }
        if (criteriaType == PathCriteriaSelectionType.MINIMUM_TIME) {
            calculateMinimumTimePath(startStation, endStation);
        }
    }

    private static void calculateMinimumTimePath(Station startStation, Station endStation) {
        MinimumTimePathFinder.find(startStation, endStation);
    }

    private static void calculateShortestDistancePath(Station startStation, Station endStation) {
        ShortestDistancePathFinder.find(startStation, endStation);
    }
}
