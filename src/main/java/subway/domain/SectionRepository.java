package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    private static void validateSectionLineNameDuplicate(String lineName)
        throws IllegalArgumentException {
        if (sections.stream().anyMatch(section -> section.getLine().getName().equals(lineName))) {
            throw new IllegalArgumentException();
        }
    }

    public static void addSection(Section section) throws IllegalArgumentException {
        validateSectionLineNameDuplicate(section.getLine().getName());
        sections.add(section);
    }

    public static boolean deleteSectionByLineName(String lineName) {
        return sections.removeIf(section -> Objects.equals(section.getLine().getName(), lineName));
    }

    public static void deleteAll() {
        sections.clear();
    }
}
