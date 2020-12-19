package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class StationService {
    public static List<String> stationNames() {
        List<Station> stations = StationRepository.stations();
        List<String> stationNames = new ArrayList<>();

        for (Station station : stations) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }
}
