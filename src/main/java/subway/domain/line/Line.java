package subway.domain.line;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    private String name;
    private static LineStations lineStations;

    public Line(String name, List<LineStation> lineStations) {
        this.name = name;
        this.lineStations = new LineStations(lineStations);
    }

    public String getName() {
        return name;
    }

    public static Line makeList(String name, Station firstStation) {
        Line line = new Line(name, new ArrayList(Arrays.asList(firstStation)));
        return line;
    }

    public static void addStation(Station station) {
        lineStations.add(station);
    }
}
