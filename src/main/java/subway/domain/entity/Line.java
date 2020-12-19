package subway.domain.entity;

import java.util.Objects;

public class Line {
    private static final int MINIMUM_LINE_NAME_LENGTH = 2;

    private final String name;
    private final Stations stations;

    public Line(String name, Stations stations) {
        validateName(name);
        this.name = name;
        this.stations = stations;
    }

    private void validateName(String name) {
        if (Objects.isNull(name)) {
            throw new LineNameException();
        }
        int trimNameLength = name.trim().length();
        if (trimNameLength < MINIMUM_LINE_NAME_LENGTH) {
            throw new LineNameException();
        }
    }

    public void addStation(Station station, Section section) {
        stations.addStation(station, section);
    }

    public boolean matchesName(String name) {
        return Objects.equals(this.name, name);
    }

    public String getName() {
        return name;
    }
}
