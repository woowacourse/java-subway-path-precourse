package subway.domain;

import subway.exception.SubwayException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sections {
    private List<Section> sections;

    public Sections() {
        sections = new ArrayList<>();
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public List<Section> getUnmodifiableList() {
        return Collections.unmodifiableList(sections);
    }

    public void addAll(List<Section> others) {
        sections.addAll(others);
    }

    public Section findByName(String from, String to) {
        return sections.stream()
                .filter(section -> section.from().getName().equals(from) && section.to().getName().equals(to))
                .findAny()
                .orElseThrow(() -> new SubwayException("해당 구간이 없습니다."));
    }
}
