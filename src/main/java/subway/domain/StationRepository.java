package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class StationRepository {
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
        stations.add(station);

        return new StationRepository(stations);
    }

    public StationRepository deleteStation(String name) {
        stations.removeIf(station -> Objects.equals(station.getName(), name));

        return new StationRepository(stations);
    }

    public StationRepository deleteAll() {
        stations.clear();

        return new StationRepository();
    }
}
