package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> sections;

    public Line(String name) {
        this.name = name;
        this.sections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        this.sections.add(station);
    }


    // 추가 기능 구현
}
