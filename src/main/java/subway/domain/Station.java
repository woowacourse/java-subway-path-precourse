package subway.domain;

import subway.domain.repository.StationRepository;
import subway.util.PathCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station {
    private final String name;
    private final List<NearbyStation> nearbyStations = new ArrayList<>();
    private final String NEARBY_STATION_NOT_FOUND = "해당 인근 역을 찾지 못했습니다.";

    private Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        Station station = new Station(name);
        PathCalculator.addStation(station.getName());
        StationRepository.addStation(station);
        return station;
    }

    public NearbyStation findNearbyStationByName(String name) {
        Station station = StationRepository.findStationByName(name);
        return nearbyStations.stream()
                .filter(nearbyStation -> nearbyStation.getStation().equals(station))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(NEARBY_STATION_NOT_FOUND));
    }

    public void addNearbyStation(NearbyStation nearbyStation) {
        nearbyStations.add(nearbyStation);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Station) {
            Station station = (Station) obj;
            return station.getName().equals(name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
