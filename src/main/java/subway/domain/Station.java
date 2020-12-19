package subway.domain;

import subway.exception.DuplicatedStationException;

public class Station {

    private final String name;

    public Station(String name) {
        validateDuplicatedName(name);
        this.name = name;
    }

    private void validateDuplicatedName(String name) {
        if (StationRepository.exists(name)) {
            throw new DuplicatedStationException();
        }
    }

    public String getName() {
        return name;
    }
}
