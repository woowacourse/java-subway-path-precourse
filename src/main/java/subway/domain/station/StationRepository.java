package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.domain.util.SetupConstant.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static void setUp() {
        addStation(new Station(STATION_GYODAE));
        addStation(new Station(STATION_GANGNAM));
        addStation(new Station(STATION_YEOKSAM));
        addStation(new Station(STATION_NAMBU_TERMINAL));
        addStation(new Station(STATION_YANGJAE));
        addStation(new Station(STATION_YANGJAE_CITIZENS_FOREST));
        addStation(new Station(STATION_MAEBONG));
    }

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
                .filter(station -> station.nameEquals(name))
                .findAny()
                .orElse(null);
    }
}
