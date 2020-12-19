package subway.repository;

import subway.domain.Section;
import subway.domain.Station;
import subway.exception.SubwayException;
import subway.view.TextCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> lines() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static Section searchSection(Station sourceStation, Station targetStation) {
        return sections.stream()
                .filter(section -> section.matches(sourceStation, targetStation))
                .findFirst()
                .orElseThrow(() -> new SubwayException(TextCollection.NOT_EXIST_SECTION_MESSAGE));
    }
}
