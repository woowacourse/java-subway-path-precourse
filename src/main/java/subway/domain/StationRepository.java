package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
        addStation(new Station("교대역"));
        addStation(new Station("강남역"));
        addStation(new Station("역삼역"));
        addStation(new Station("남부터미널역"));
        addStation(new Station("매봉역"));
        addStation(new Station("양재역"));
        addStation(new Station("양재시민의 숲 역"));
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
