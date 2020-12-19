package subway.domain.line.model;

import subway.station.model.Station;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private final List<Station> stations;

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = new ArrayList<>(stations);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
