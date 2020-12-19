package subway.domain;

import subway.exception.SubwayException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String ERROR_NOT_FOUND_NAME_MSG = "해당하는 이름의 역이 없습니다.";

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

    public static Station findByName(String name) {
        return stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findAny()
                .orElseThrow(() -> new SubwayException(ERROR_NOT_FOUND_NAME_MSG));
    }
}
