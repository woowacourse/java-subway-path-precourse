package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;

public class StationService {
    public static void addStation(String stationName) {
        Station station = new Station(stationName);
        StationRepository.addStation(station);
    }
}
