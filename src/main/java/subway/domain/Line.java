package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Station> lineStations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addLineStation(List<String> stationNames) {
        for (String stationName : stationNames) {
            Station station = new Station(stationName);
            lineStations.add(station);
        }
    }
}
