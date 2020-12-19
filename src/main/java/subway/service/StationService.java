package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public static Station findStationByName(String name) {
        return StationRepository.stations().stream()
            .filter(station -> station.getName().equals(name))
            .findAny()
            .get();
    }
}
