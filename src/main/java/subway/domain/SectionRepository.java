package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.exception.InputException;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();
    public static final String SECTION_DONT_EXISTS = "구간이 존재하지 않습니다.";

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static void deleteAll() {
        sections.clear();
    }

    public static Section findByName(String s1, String s2) {
        return sections.stream()
                .filter(section -> section.getSource().getName().equals(s1) && section.getTarget()
                        .getName().equals(s2))
                .findAny()
                .orElseThrow(() -> new InputException(SECTION_DONT_EXISTS));
    }
}
