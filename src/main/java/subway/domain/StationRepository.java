package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final String NOT_FOUND_ERROR_MESSAGE = "해당 역이 존재하지 않습니다.";

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static Station selectByName(String name) {
        return stations.stream()
                .filter(station -> station.isMatchedName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR_MESSAGE));
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static boolean isExistent(String name) {
        return stations.stream()
                .anyMatch(station -> station.isMatchedName(name));
    }
}
