package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> sections;

    public Line(String name) {
        this.name = name;
        sections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addByName(String name) {
        Station station = StationRepository.findStation(name);
        sections.add(station);
    }
}
