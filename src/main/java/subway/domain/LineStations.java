package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class LineStations {
    private List<Station> stations;

    public LineStations() {
        this.stations = new ArrayList<>();
    }

    public void addLineStation(Station station) {
        stations.add(station);
    }
}
