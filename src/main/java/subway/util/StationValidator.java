package subway.util;

import subway.domain.StationRepository;

public class StationValidator {
    private static final String ERROR = "[ERROR] ";
    private static final String DUPLICATE_MESSAGE = "출발역과 도착역이 동일합니다.";
    private static final String AVAILABLE_STATION_MESSAGE = "연결되어있지 않은 역입니다.";
    private static final String NONEEXIST_STATION = "존재하지 않는 역입니다.";

    public static boolean checkVailableArrivalStation(String startStation, String arrivalStation) {
        return isLinkedStation(startStation, arrivalStation) && ! duplicateStation(startStation, arrivalStation);

    }

    public static boolean haveStation(String name) {
        if (StationRepository.findStationByName(name) != null) {
            return true;
        }
        System.out.println(ERROR + NONEEXIST_STATION);
        System.out.println();
        return false;
    }

    public static boolean isLinkedStation(String startStation, String arrivalStation) {
        if (StationRepository.findStationByName(arrivalStation) != null) {
            return true;
        }
        System.out.println(ERROR + AVAILABLE_STATION_MESSAGE);
        System.out.println();
        return false;
    }

    public static boolean duplicateStation(String startStation, String arrivalStation) {
        if (startStation.equals(arrivalStation)) {
            System.out.println(ERROR + DUPLICATE_MESSAGE);
            System.out.println();
            return true;
        }
        return false;
    }
}
