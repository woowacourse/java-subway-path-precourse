package subway.service;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationService {
    StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void add(Station station) {
        stationRepository.save(station);
    }
}
