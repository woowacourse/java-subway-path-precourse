package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static void initStationRepository() {
        stations.add(Station.newStationWithName("교대역"));
        stations.add(Station.newStationWithName("강남역"));
        stations.add(Station.newStationWithName("역삼역"));
        stations.add(Station.newStationWithName("남부터미널역"));
        stations.add(Station.newStationWithName("양재역"));
        stations.add(Station.newStationWithName("양재시민의숲역"));
        stations.add(Station.newStationWithName("매봉역"));
        stations.add(Station.newStationWithName("현구역"));
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
}
