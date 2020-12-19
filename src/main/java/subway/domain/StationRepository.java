package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String ERROR_NOT_FOUND_STATION_BY_NAME = "[ERROR] 해당 이름의 역을 찾지 못했습니다.";

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

    public static Station findStationByName(String stationName) {
        return stations().stream()
                .filter(station -> station.getName().equals(stationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND_STATION_BY_NAME));
    }
}
