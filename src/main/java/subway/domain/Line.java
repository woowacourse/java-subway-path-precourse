package subway.domain;

import java.util.List;

public class Line {
    private List<Station> stations;

    private String name;

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
