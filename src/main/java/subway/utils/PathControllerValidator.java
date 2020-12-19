package subway.utils;

import subway.domain.station.StationRepository;
import subway.view.message.ErrorMessage;

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
        if (namesAreSame(startingStation, finishingStation)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_DUPLICATE);
        }
    }

    private static boolean namesAreSame(String startingStation, String finishingStation) {
        return startingStation.equals(finishingStation);
    }

    private static void validateConnected(String startingStation, String finishingStation) {
    }
}
