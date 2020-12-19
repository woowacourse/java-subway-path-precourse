package subway.utils;

import subway.domain.StationRepository;
import subway.view.ErrorMessage;

public class PathControllerValidator {

    public static void validateStations(String startingStation, String finishingStation) {
        validateExisting(startingStation);
        validateExisting(finishingStation);
        validateDuplicate(startingStation, finishingStation);
        validateConnected(startingStation, finishingStation);
    }

    private static void validateExisting(String stationName) {
        if (!StationRepository.checkExistence(stationName)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_NONE);
        }
    }

    private static void validateDuplicate(String startingStation, String finishingStation) {

    }

    private static void validateConnected(String startingStation, String finishingStation) {

    }
}
