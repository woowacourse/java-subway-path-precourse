package subway.domain.station;

import subway.domain.line.Line;
import subway.exception.station.DuplicateStationNameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    private static final List<Line> lines = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void save(Station station) {
        if (stations.contains(station)) {
            throw new DuplicateStationNameException(station.getName());
        }
        stations.add(station);
    }

    public static void saveAll(List<Station> stations) {
        stations.forEach(StationRepository::save);
    }


    public static void addStation(Station station) {
        stations.add(station);
    }

    public static List<Integer> findIndexByStationName(Station firstStation, Station secondStation) {
        int firstStationIndex = lines.indexOf(firstStation);
        int secondStationIndex = lines.indexOf(secondStation);

        List<Integer> result = new ArrayList<>();
        if (firstStationIndex != -1 && secondStationIndex != -1) {
            result.add(firstStationIndex);
            result.add(secondStationIndex);
        }
        return result;
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
