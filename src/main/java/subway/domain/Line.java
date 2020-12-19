package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private final List<Station> stations = new LinkedList<>();

    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    // 추가 기능 구현
    public void addStation(Station station) {
        stations.add(station);
    }
}
