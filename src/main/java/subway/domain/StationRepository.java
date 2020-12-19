package subway.domain;

import java.util.*;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
        Station station1 = new Station("교대역");
        Station station2 = new Station("강남역");
        Station station3 = new Station("역삼역");
        Station station4 = new Station("남부터미널역");
        Station station5 = new Station("양재역");
        Station station6 = new Station("양재시민의숲역");
        Station station7 = new Station("매봉역");
        addStation(station1);
        addStation(station2);
        addStation(station3);
        addStation(station4);
        addStation(station5);
        addStation(station6);
        addStation(station7);
    }

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
