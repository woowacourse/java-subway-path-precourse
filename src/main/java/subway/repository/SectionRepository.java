package subway.repository;

import subway.domain.RequiredResources;
import subway.domain.Section;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SectionRepository {
    private static Map<Section, RequiredResources> sections = new HashMap<>();

    public static Map<Section, RequiredResources> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static void addSection(Section section, RequiredResources requiredResources) {
        sections.put(section, requiredResources);
    }

    public static void deleteAll() {
        sections.clear();
    }
}
