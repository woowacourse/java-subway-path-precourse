package subway.repository;

import subway.domain.Stations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StationsRepository {
    private static final List<Stations> upDownStations = new ArrayList<>();

    public static List<Stations> upDownStations() {
        return Collections.unmodifiableList(upDownStations);
    }

    public static void addUpDownStations(Stations stations) {
        upDownStations.add(stations);
    }
}
