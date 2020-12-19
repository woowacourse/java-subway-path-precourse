package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stationsOnLine = new ArrayList<>();


    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStationOnLine(Station station) {

    }

    // 추가 기능 구현
}
