package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.StationNotExistException;

import java.util.Optional;

public class StationService {
    public static Station getStationByName(String stationName) {
        Optional<Station> stationOptional = StationRepository.findStationByName(stationName);
        if(!stationOptional.isPresent()){
            throw new StationNotExistException();
        }
        return stationOptional.get();
    }
}
