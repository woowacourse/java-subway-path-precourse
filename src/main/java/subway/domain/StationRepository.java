package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    private StationRepository() {
    }

    public static void initStationRepository() {
        addStation(Station.newStationWithName("교대역"));
        addStation(Station.newStationWithName("강남역"));
        addStation(Station.newStationWithName("역삼역"));
        addStation(Station.newStationWithName("남부터미널역"));
        addStation(Station.newStationWithName("양재역"));
        addStation(Station.newStationWithName("양재시민의숲역"));
        addStation(Station.newStationWithName("매봉역"));
    }

    public static List<Station> stations() {
        validateEmpty();
        return Collections.unmodifiableList(stations);
    }

    private static void validateEmpty() {
        if (stations.isEmpty()) {
            throw new IllegalArgumentException("등록되어 있는 지하철 역이 없습니다.");
        }
    }

    public static void addStation(Station station) {
        validateDuplicate(station);
        stations.add(station);
    }

    private static void validateDuplicate(Station station) {
        if (stations.stream().anyMatch(s -> s.getName().equals(station.getName()))) {
            throw new IllegalArgumentException("이미 같은 이름의 지하철 역이 등록되어 있습니다.");
        }
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
