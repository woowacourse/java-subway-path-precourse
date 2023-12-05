package subway.service;

import subway.domain.Station;
import subway.domain.StationInfo;
import subway.repository.StationRepository;

public class StationService {
    private final StationRepository stationRepository;

    private StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public static StationService createStationService(StationRepository stationRepository) {
        return new StationService(stationRepository);
    }

    public void registerStation() {
        for (StationInfo stationInfo : StationInfo.values()) {
            stationRepository.addStation(new Station(stationInfo.getName()));
        }
    }
}
