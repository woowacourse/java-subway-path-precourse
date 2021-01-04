package subway.repository;

import subway.domain.Station;
import subway.exception.SubwayException;
import subway.view.TextCollection;

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

    public static Station searchStation(String name) {
        return stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findFirst()
                .orElseThrow(() -> new SubwayException(TextCollection.NOT_EXIST_STATION_MESSAGE));
    }
}
