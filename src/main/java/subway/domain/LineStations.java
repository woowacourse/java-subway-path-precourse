package subway.domain;

import java.util.List;

public class LineStations {
    private List<Station> stations;

    public void addLineStation(Station station) {
        stations.add(station);
    }
}
