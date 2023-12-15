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

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean existByName(String name) {
        return stations.stream().filter(station -> station.isSameName(name)).count() > 0;
    }

    public static Station findByName(String name) {
        return stations().stream().filter(station -> station.isSameName(name)).findFirst().orElseThrow();
    }

    public static void deleteAll() {
        stations.clear();
    }
}
