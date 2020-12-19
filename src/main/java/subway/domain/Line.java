package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }
}
