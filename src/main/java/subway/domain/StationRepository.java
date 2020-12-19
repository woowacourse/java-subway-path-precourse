package subway.domain;

import java.util.*;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static Optional<Station> findStationByName(String stationName) {
        List<Station> stationList = stations.stream()
                .filter(station -> station.getName().equals(stationName))
                .collect(Collectors.toList());
        if(stationList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(stationList.get(0));
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
