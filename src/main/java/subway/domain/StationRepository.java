package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final String STATION_NOT_EXIST_MESSAGE = "존재하지 않는 역이름입니다.";

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
        TimeGraph.addVertex(station);
        DistanceGraph.addVertex(station);
    }

    public static Station getStationByName(String name) {
        return stations.stream().filter(station -> station.getName().equals(name)).findAny()
                .orElseThrow(() -> new IllegalArgumentException(STATION_NOT_EXIST_MESSAGE));
    }
    
    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
