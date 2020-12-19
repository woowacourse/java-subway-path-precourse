package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public static void addStation(String name) {
        StationRepository.addStation(new Station(name));
    }

}
