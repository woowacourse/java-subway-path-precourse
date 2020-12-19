package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stationInLine = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public void addStationInLine(Station station) {
        stationInLine.add(station);
    }

    public String getName() {
        return name;
    }

    public List<Station> stationsInLine() {
        return Collections.unmodifiableList(stationInLine);
    }

}
