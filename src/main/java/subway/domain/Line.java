package subway.domain;

import java.util.ArrayList;
import java.util.List;
import subway.exception.DuplicatedLineException;

public class Line {

    private final String name;

    public List<Section> getSections() {
        return sections;
    }

    private final List<Section> sections;

    public Line(String name) {
        validateDuplicatedName(name);
        this.name = name;
        sections = new ArrayList<>();
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    private void validateDuplicatedName(String name) {
        if (LineRepository.exists(name)) {
            throw new DuplicatedLineException();
        }
    }

    public String getName() {
        return name;
    }
}
