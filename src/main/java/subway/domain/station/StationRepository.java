package subway.domain.station;

import subway.exception.station.DuplicateStationNameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void save(Station station) {
        if (stations.contains(station)) {
            throw new DuplicateStationNameException(station.getName());
        }
        stations.add(station);
    }

    public static void saveAll(List<Station> stations) {
        stations.forEach(StationRepository::save);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
