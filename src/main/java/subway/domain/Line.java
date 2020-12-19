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
        if (StationRepository.stations().contains(section.getSourceStationName())
                && StationRepository.stations().contains(section.getTargetStationName())) {
            sections.add(section);
        }
    }

    public List<Section> getSections() {
        return sections;
    }
}
