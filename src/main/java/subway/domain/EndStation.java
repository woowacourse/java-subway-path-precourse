package subway.domain;

import exception.NoExistStationException;

public class EndStation {
    private final String stationName;

    public EndStation(String name) {
        validateStation(name);
        stationName = name;
    }

    void validateStation(String name) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(name)) {
                return;
            }
        }
        throw new NoExistStationException();
    }

    public String getStationName() {
        return stationName;
    }
}
