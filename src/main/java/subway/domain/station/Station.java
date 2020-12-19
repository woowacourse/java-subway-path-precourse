package subway.domain.station;

import java.util.Objects;
import javax.naming.InvalidNameException;
import subway.exception.InvalidStationNameException;

public class Station {

    private static final int NAME_MIN_LENGTH = 2;

    private String name;

    private Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Station of(String name) {

        if (name == null || name.isEmpty()) {
            throw new InvalidStationNameException();
        }

        if (name.length() < NAME_MIN_LENGTH) {
            throw new InvalidStationNameException();
        }

        return new Station(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        return getName().equals(((Station) o).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isMatchName(String name) {
        return this.name.equals(name);
    }

    // 추가 기능 구현
}
