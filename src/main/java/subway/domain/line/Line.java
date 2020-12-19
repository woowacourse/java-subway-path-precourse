package subway.domain.line;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private List<String> stations = new LinkedList<>();

    public Line(String name, List<String> dummyStations) {
        this.name = name;
        stations.addAll(dummyStations);
    }

    public String getName() {
        return name;
    }

    public static Line from(String name, List<String> stations) {
        return new Line(name, stations);
    }

    public boolean contains(String station) {
        return stations.contains(station);
    }

    public boolean validSequence(String firstStation, String lastStation) {
        return stations.indexOf(firstStation) < stations.indexOf(lastStation);
    }
}
