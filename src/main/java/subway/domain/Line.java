package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    private Line(String name) {
        this.name = name;
    }

    public static Line from(String name) {
        Line line = new Line(name);
        LineRepository.addLine(line);
        return line;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        stations.add(station);
    }
}
