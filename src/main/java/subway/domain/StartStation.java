package subway.domain;

import exception.NoExistStationException;

public class StartStation {
    private final String stationName;

    public StartStation(String name) {
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
