package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    private List<Station> stationList = new ArrayList<>();

    public List<Station> stations() {
        return Collections.unmodifiableList(stationList);
    }

    public void addStation(Station station) {
        stationList.add(station);
    }

    public boolean deleteStation(String name) {
        return stationList.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
