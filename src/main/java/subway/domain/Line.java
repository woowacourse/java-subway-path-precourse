package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;
    private List<Integer> distance;
    private List<Integer> time;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
