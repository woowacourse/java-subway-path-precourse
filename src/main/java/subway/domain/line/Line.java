package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import subway.domain.section.Section;

public class Line {
    private static final String SECTION_ADDING_OTHER_LINE_RECEIVE_MESSAGE = "구간 추가시 다른 노선을 받았습니다.";

    private final String name;
    private final List<Section> sectionList = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Section> getSectionList() {
        return Collections.unmodifiableList(this.sectionList);
    }

    public void addSection(Section section) {
        this.validateSection(section);
        this.sectionList.add(section);
    }

    private void validateSection(Section section) {
        if(this != section.getLine()) {
            throw new IllegalArgumentException(SECTION_ADDING_OTHER_LINE_RECEIVE_MESSAGE);
        }
    }
}
