package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Section> sections;

    public Line(String name, List<Section> sections) {
        this.name = name;
        this.sections = sections;
    }

    public String getName() {
        return name;
    }
    // 추가 기능 구현
    public List<Section> sections() {
        return sections;
    }

    public boolean isExistStationInSections(Station station) {
        return sections.stream().anyMatch(section -> section.isStartStation(station));
    }
}
