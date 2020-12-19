package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name) {
        this.name = name;
        this.stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    // 추가 기능 구현
    public void addStations(String... names) {
        Arrays.stream(names).forEach(name -> stations.add(new Station(name)));
    }
}
