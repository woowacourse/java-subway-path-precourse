package subway.pathfind;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.pathfind.validator.Validator;

public class PathCalculator {

    public static void start(Scanner scanner, PathCriteriaSelectionType criteriaType)  throws IllegalArgumentException {
        Station startStation = getInputStartStation(scanner);
        Station endStation = getInputEndStation(scanner);
        Validator.validateNotEqualStation(startStation, endStation);
        calculate(startStation, endStation, criteriaType);
    }

    private static Station getInputEndStation(Scanner scanner) throws IllegalArgumentException {
        PathCalculatorPrinter.printEndStationUserInputMessage();
        String endStationName = scanner.nextLine();
        Station foundStation = StationRepository.findByName(endStationName);
        Validator.validateExistsStation(foundStation);
        return foundStation;
    }

    private static Station getInputStartStation(Scanner scanner) throws IllegalArgumentException {
        PathCalculatorPrinter.printStartStationUserInputMessage();
        String startStationName = scanner.nextLine();
        Station foundStation = StationRepository.findByName(startStationName);
        Validator.validateExistsStation(foundStation);
        return foundStation;
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
