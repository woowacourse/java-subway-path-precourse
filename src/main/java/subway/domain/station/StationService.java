package subway.domain.station;

import java.util.List;
import java.util.Optional;

public class StationService {
    private static final String NOT_EXISTS_STATION_MESSAGE = "존재하지 않은 역입니다.";
    private static final String ALREADY_EXISTS_STATION_MESSAGE = "이미 등록되어있는 역입니다.";

    public Station findOneByName(String name) {
        return StationRepository.findByName(name)
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_STATION_MESSAGE));
    }

    public Optional<Station> findByName(String name) {
        return StationRepository.findByName(name);
    }

    public List<Station> findAll() {
        return StationRepository.stations();
    }

    public void addStation(StationDTO stationDTO) {
        Station station = new Station(stationDTO.getName());
        if (StationRepository.exists(station)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_STATION_MESSAGE);
        }
        StationRepository.addStation(station);
    }

    public void deleteAll() {
        StationRepository.deleteAll();
    }
}
