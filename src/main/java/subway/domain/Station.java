package subway.domain;

import subway.error.SubwayErrorMessage;
import subway.error.SubwayException;

import java.util.Objects;

public class Station {
    private static final int NAME_MIN_LENGTH = 2;
    private String name;

    public Station(String name) {
        if(name.length() < NAME_MIN_LENGTH) {
            throw new SubwayException(SubwayErrorMessage.STATION_NAME_SHORT);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return getName().equals(station.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
