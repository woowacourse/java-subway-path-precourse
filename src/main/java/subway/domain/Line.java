package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private LineStations stations;

    public Line(String name) {
        this.name = name;
        this.stations = new LineStations();
    }

    public String getName() {
        return name;
    }

    public void addLineStation(Station station) {
        stations.addLineStation(station);
    }
}
