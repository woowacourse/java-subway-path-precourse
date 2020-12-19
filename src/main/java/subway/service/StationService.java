package subway.service;

import java.util.NoSuchElementException;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public static Station findStationByName(String name) {
        try {
            return StationRepository.stations().stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .get();
        } catch (NoSuchElementException e){
            throw new IllegalArgumentException("해당 역이 존재하지 않습니다.");
        }
    }
}
