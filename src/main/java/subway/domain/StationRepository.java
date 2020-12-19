package subway.domain;

import subway.exception.SubwayProgramException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final String STATION_NOT_EXIST_ERROR = "등록되어 있지 않은 역입니다.";
    private static final String SAME_STATION_ERROR = "출발역과 도착역이 동일합니다.";

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
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

    public static Station findByStationName(String name) {
        return stations.stream()
                .filter(station -> station.isSame(name))
                .findFirst()
                .orElseThrow(() -> new SubwayProgramException(STATION_NOT_EXIST_ERROR));
    }

    public static void validateSameStation(Station startStation, Station arrivalStation) {
        if (startStation.equals(arrivalStation)) {
            throw new SubwayProgramException(SAME_STATION_ERROR);
        }
    }
}
