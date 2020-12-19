package subway.domain.line;

import java.util.List;

public class Line {
    private String name;
    private ResisteredStations resisterdStations;

    public Line(String name) {
        this.name = name;
    }

    public static Line createWithInitialStations(String lineName, List<String> initialStations) {
        Line line = new Line(lineName);
        line.resisterdStations = new ResisteredStations(initialStations);
        return line;
    }

    public String getName() {
        return name;
    }

    public List<String> getStations() {
        return resisterdStations.stations();
    }
}
