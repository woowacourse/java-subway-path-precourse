package subway.repository;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Section;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }
}
