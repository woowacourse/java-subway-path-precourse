package subway.service;

import subway.domain.entity.Section;
import subway.domain.entity.Station;
import subway.domain.entity.Stations;
import subway.domain.repository.StationRepository;

public class StationService {

    private StationService() {
    }

    public static Stations generateStations(String upwardLastStationName, String nextStationName, Section section) {
        Station upwardLastStation = findStationByName(upwardLastStationName);
        Station nextStation = findStationByName(nextStationName);
        return Stations.of(upwardLastStation, nextStation, section);
    }

    public static Station findStationByName(String name) {
        return StationRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
    }
}
