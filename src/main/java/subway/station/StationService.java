package subway.station;

import java.util.List;

public class StationService {
    public void addAllStation(List<Station> stations) {
        for (Station station : stations) {
            StationRepository.addStation(station);
        }
    }

    public Station findStation(String name) {
        return StationRepository.findByName(name);
    }
}
