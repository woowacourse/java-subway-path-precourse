package subway.controller.validation;

import subway.service.StationService;
import subway.view.OutputView;

import java.util.List;

public class PathValidation {
    public static void isValidStations(String origin, String destination) {
        if (isSameStations(origin, destination)) {
            OutputView.printInvalidSameStationsException();
        }
        if (!isExistingStations(origin, destination)) {
            OutputView.printInvalidExistingStationsException();
        }
    }

    public static boolean isSameStations(String origin, String destination) {
        return origin.equals(destination);
    }

    public static boolean isExistingStations(String origin, String destination) {
        List<String> stationNames = StationService.stationNames();

        return (stationNames.contains(origin)) && (stationNames.contains(destination));
    }
}
