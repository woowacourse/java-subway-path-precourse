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

    public static void addSetion(Section section) {
        sections.add(section);
    }

    public static boolean deleteSectionByName(String name) {
        return sections.removeIf(line -> Objects.equals(line.getLinkedStationName(), name));
    }

    public static void deleteAll() {
        sections.clear();
    }
}
