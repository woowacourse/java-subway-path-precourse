package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {

    public static final String DUPLICATE_STATION_ERROR = "[ERROR] 해당 역은 이미 등록되어 있습니다.";

    public static final String NOT_FOUND_STATION_ERROR = "[ERROR] 해당 역은 존재하지 않습니다.";

    private final List<Station> stations;

    public StationRepository() {
        this.stations = new LinkedList<>();
    }

    public StationRepository(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public StationRepository addStations(final String... stationNames) {
        StationRepository stationRepository = new StationRepository();

        for (String stationName : stationNames) {
            stationRepository.addStation(new Station(stationName));
        }

        return stationRepository;
    }

    public StationRepository addStation(Station station) {
        if (stations().contains(station)) {
            throw new IllegalArgumentException(DUPLICATE_STATION_ERROR);
        }

        stations.add(station);

        return new StationRepository(stations);
    }

    public StationRepository deleteStation(String name) {
        boolean removed = stations.removeIf(station -> Objects.equals(station.getName(), name));

        if (!removed) {
            throw new IllegalArgumentException(NOT_FOUND_STATION_ERROR);
        }
        return new StationRepository(stations);
    }

    public StationRepository deleteAll() {
        stations.clear();

        return new StationRepository();
    }

    public List<String> getStationNames() {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}
