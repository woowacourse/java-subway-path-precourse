package subway.domain;

import subway.repository.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Section> sections = new ArrayList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSection(Section section) {
        Station sourceStation = new Station(section.getSourceStationName());
        Station targetStation = new Station(section.getTargetStationName());

        sections.add(section);
    }

    public List<Section> getSections() {
        return sections;
    }
}
