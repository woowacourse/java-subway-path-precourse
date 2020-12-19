package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private final List<Section> sections = new ArrayList<>();

    public void addSection(Section section) {
        sections.add(section);
        SectionRepository.addSection(section);
    }

    public List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }
}
