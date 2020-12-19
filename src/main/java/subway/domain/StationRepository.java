package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.exceptions.ExceptionStationNotExists;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static Station getStationByName(String stationName) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(stationName)) {
                return station;
            }
        }
        return null;
    }

    public static void isValidStationName(String stationName) {
        if (!stations.contains(new Station(stationName))) {
            throw new ExceptionStationNotExists();
        }
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
