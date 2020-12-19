package subway.pathfind.validator;

import subway.domain.Station;
import subway.pathfind.printer.error.PathFindErrorPrinter;

public class Validator {
    public static void validateExistsStation(Station foundStation) throws IllegalArgumentException {
        if (foundStation == null) {
            PathFindErrorPrinter.printNotExistsStationErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateNotEqualStation(Station startStation, Station endStation) {
        if (startStation.getName().equals(endStation.getName())) {
            PathFindErrorPrinter.printStartEndStationEqualErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
