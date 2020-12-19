package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Section> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSection(Station station, Station nextStation, int distance, int time) {
        if (sections.stream().noneMatch(section -> section.getStation().equals(station))) {
            sections.add(new Section(station, nextStation, distance, time));
        }
    }

    public List<Section> getSections() {
        return this.sections;
    }
}
