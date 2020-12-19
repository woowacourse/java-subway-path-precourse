package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public static Station getStationByName(String name) {
        Optional<Station> optional =
                stations.stream().filter(it -> it.getName() == name).findFirst();
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public static void deleteAll() {
        stations.clear();
    }
}
