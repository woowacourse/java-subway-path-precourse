package subway.service;

import subway.domain.PathRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.validation.StationValidation;

public class StationService {

    private static final int NAME_LENGTH_LIMIT = 2;

    public static boolean addStation(String stationName) {
        if (StationValidation.checkInsertStation(stationName)) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
            PathRepository.addStation(station);
            return true;
        }
        return false;
    }

    public static Station getStationByName(String stationName) {
        if (StationValidation.checkGetStation(stationName)) {
            return StationRepository.findByName(stationName);
        }
        return null;
    }

    public static boolean isAlreadyExistStation(String stationName) {
        return StationRepository.isDuplicatedStation(new Station(stationName));
    }

    public static boolean isUnderNameLength(String name) {
        return name.length() < NAME_LENGTH_LIMIT;
    }

}
