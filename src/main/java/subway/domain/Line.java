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

    public void addSection(Section section) {
        if (sections.stream()
            .noneMatch(exSection -> exSection.getStationName().equals(section.getStationName()))) {
            sections.add(section);
        }
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public boolean hasStation(String stationName) {
        for (Section section : sections) {
            if (section.getStationName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }
}
