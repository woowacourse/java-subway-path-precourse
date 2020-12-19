package subway.domain.station;

import subway.exception.StationNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationRepository {
    private final List<Station> stations = new ArrayList<>();

    public void save(Station station) {
        stations.add(station);
    }

    public Station findByName(String name) {
        return stations.stream()
                .filter(station -> station.isSameName(name))
                .findAny()
                .orElseThrow(StationNotFoundException::new);
    }

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public boolean delete(Station targetStation) {
        return stations.removeIf(station -> station.equals(targetStation));
    }
}
