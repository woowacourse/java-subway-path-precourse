package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.message.ErrorMessage;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    private static boolean stationNameExists(String name) {
        return stations.stream().anyMatch(station -> station.getName().equals(name));
    }

    public static void validateStationNameDuplicate(String stationName)
        throws IllegalArgumentException {
        if (stationNameExists(stationName)) {
            throw new IllegalArgumentException(
                ErrorMessage.STATION_REPOSITORY_STATION_ALREADY_EXIST.toString()
            );
        }
    }

    public static void validateStationNameExist(String stationName)
        throws IllegalArgumentException {
        if (!stationNameExists(stationName)) {
            throw new IllegalArgumentException(
                ErrorMessage.STATION_REPOSITORY_STATION_DOES_NOT_EXIST.toString()
            );
        }
    }

    public static void addStation(Station station) throws IllegalArgumentException {
        validateStationNameDuplicate(station.getName());
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
