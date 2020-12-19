package subway.domain;

import subway.exception.CannotFindStationByName;

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

    public static void deleteAll() {
        stations.clear();
    }

    public static void addAllStation(List<Station> stationList) {
        for (Station station : stationList) {
            addStation(station);
        }
    }

    public static Station getStationByName(String name) {
        return stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findAny()
                .orElseThrow(()-> {
                   throw new CannotFindStationByName(name);
                });
    }
}
