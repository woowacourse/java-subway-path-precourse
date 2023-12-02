package subway.service;

import subway.repository.StationRepository;

public class StationService {
    private final StationRepository stationRepository = StationRepository.getInstance();

    public void initStation(){
        stationRepository.initStation();
    }
}
