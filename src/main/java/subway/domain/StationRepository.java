package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.exception.SubwayException;

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

    public static void deleteAll() {
        stations.clear();
    }

    public static boolean hasStation(String name) {
        return stations.stream().anyMatch(station -> Objects.equals(station.getName(), name));
    }

    public static Station findStation(String name) {
        return stations.stream()
            .filter(station -> Objects.equals(station.getName(), name))
            .findFirst()
            .orElseThrow(() -> new SubwayException("없는 역입니다."));
    }
}
