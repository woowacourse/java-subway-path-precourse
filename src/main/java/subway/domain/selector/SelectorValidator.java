package subway.domain.selector;

import subway.domain.Station.Station;
import subway.domain.Station.StationRepository;

public class SelectorValidator {

    private static final String SAME_STATION_NAME_ERROR = "\n[ERROR] 출발역과 도착역이 동일합니다.";
    private static final String NOT_REGISTERED_STATION_ERROR = "\n[ERROR] 등록되지 않은 역 입니다.";

    public void validateEqualName(String departureStation, String arrivalStation) {
        if (departureStation.equals(arrivalStation)) {
            throw new IllegalArgumentException(SAME_STATION_NAME_ERROR);
        }
    }

    public void validateContains(Station station) {
        if (!StationRepository.isContains(station)) {
            throw new IllegalArgumentException(NOT_REGISTERED_STATION_ERROR);
        }
    }
}
