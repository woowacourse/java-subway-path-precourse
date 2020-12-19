package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    private static void validateStationNameDuplicate(String stationName)
        throws IllegalArgumentException {
        if (stations.stream().anyMatch(station -> station.getName().equals(stationName))) {
            throw new IllegalArgumentException();
        }
    }

    public static void addStation(Station station) throws IllegalArgumentException {
        validateStationNameDuplicate(station.getName());
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
