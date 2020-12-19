package subway;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;

public class PathCalculator {

    public static void start(Scanner scanner, PathCriteriaSelectionType criteriaType) {
        Station startStation = getInputStartStation(scanner);
        Station endStation = getInputEndStation(scanner);
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
}
