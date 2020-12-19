package subway.domain;

import subway.domain.exception.NotExistingStationException;

import java.util.ArrayList;
import java.util.List;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

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
