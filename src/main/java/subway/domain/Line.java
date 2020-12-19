package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();


    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(String stationName) {
        Station station = new Station(stationName);
        stations.add(station);
    }
}
