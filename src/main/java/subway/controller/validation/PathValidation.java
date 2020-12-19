package subway.controller.validation;

import subway.service.StationService;
import subway.view.OutputView;

import java.util.List;

public class PathValidation {
    public static boolean isValidStations(String origin, String destination) {
        if (!isExistingStations(origin, destination)) {
            OutputView.printInvalidExistingStationsException();
            return false;
        }
        if (isSameStations(origin, destination)) {
            OutputView.printInvalidSameStationsException();
            return false;
        }
        return true;
    }

    public static boolean isExistingStations(String origin, String destination) {
        List<String> stationNames = StationService.stationNames();

        return (stationNames.contains(origin)) && (stationNames.contains(destination));
    }

    public static boolean isSameStations(String origin, String destination) {
        return origin.equals(destination);
    }
}
