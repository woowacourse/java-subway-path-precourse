package subway.pathfind.validator;

import java.util.List;
import subway.domain.Station;
import subway.pathfind.printer.error.PathFindErrorPrinter;

public class PathFindValidator {
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

    public static void validatePathExists(List<Station> resultPath) {
        if (resultPath.isEmpty()) {
            PathFindErrorPrinter.printPathNotExistsErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
