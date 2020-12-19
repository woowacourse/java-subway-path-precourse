package subway.domain.station;

import subway.exception.StationNameFormatException;

public class Station {
    private static final String STATION = "역";
    private static final int STATION_NAME_LENGTH = 2;

    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameFormat(name);
        validateNameLength(name);
    }

    private void validateNameFormat(String name) {
        if (!name.endsWith(STATION)) {
            throw new StationNameFormatException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length()-STATION.length() < STATION_NAME_LENGTH) {
            throw new StationNameFormatException();
        }
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
