package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public static Line of(String name, List<Station> stations) {
        Line line = new Line(name);
        line.addAll(stations);
        return line;
    }

    public void addAll(List<Station> stations) {
        this.stations.addAll(stations);
    }

    public String getName() {
        return name;
    }
}
