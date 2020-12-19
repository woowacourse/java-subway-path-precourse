package subway.domain;

import subway.domain.exception.NotExistingStationException;

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
        SearchGraph.addVertex(station);
    }

    public static Station getStation(String name) {
        return stations.stream()
                .filter(station -> station.isName(name))
                .findFirst()
                .orElseThrow(() -> new NotExistingStationException());
    }
}
