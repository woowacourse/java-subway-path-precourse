package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private final List<Station> stations = new ArrayList<>();

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public Station findByName(String name) {
        return stations.stream()
            .filter(station -> station.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public boolean isExistByName(String name) {
        return findByName(name) != null;
    }

    public boolean deleteStationByName(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
