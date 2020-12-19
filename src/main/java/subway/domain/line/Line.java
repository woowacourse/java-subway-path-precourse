package subway.domain.line;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Station> stations = new ArrayList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
