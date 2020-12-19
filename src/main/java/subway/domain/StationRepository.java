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

    public static void deleteAll() {
        stations.clear();
    }

    public static Station selectStationByName(String name) {
        return (Station) stations().stream().filter(s -> s.getName().equals(name));
    }

    public static List<Station> selectStationListByNames(List<String> stationNames) {
        List<Station> stationList = new ArrayList<>();
        for (String stationName : stationNames) {
            stationList.add((Station) stations.stream()
                    .filter(s -> s.getName()
                            .equals(stationName)));
        }
        return stationList;
    }
}
