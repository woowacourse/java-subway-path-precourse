package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Station> LineInStationList = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void lineInAddStation(Station station) {
        LineInStationList.add(station);
    }

    public boolean isEqualName(String name) {
        return name.equals(this.name);
    }
}
