package subway.domain.line;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int INDEX_CORRECTION_VALUE = 1;

    private List<Station> stations = new ArrayList<>();
    private String name;

    public Line(String name, Station topStation, Station bottomStation) {
        this.name = name;
        stations.add(topStation);
        stations.add(bottomStation);
    }

    public String getName() {
        return name;
    }

    public void insert(int index, Station station) {
        stations.add(index, station);
    }
}
