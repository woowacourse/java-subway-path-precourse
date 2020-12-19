package subway.domain;

import subway.util.PathCalculator;

import java.util.Objects;

public class Station {
    private String name;

    private Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        Station station = new Station(name);
        PathCalculator.addStation(station.getName());
        StationRepository.addStation(station);
        return station;
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
