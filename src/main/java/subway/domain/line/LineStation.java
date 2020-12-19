package subway.domain.line;

import subway.domain.station.Station;

public class LineStation {

    private final Station station;

    public LineStation(Station station) {
        this.station = station;
    }

    public String getStationName() {
        return station.getName();
    }

    public Station getStation() {
        return station;
    }

    public static LineStation of(Station station) {
        return new LineStation(station);
    }
}
