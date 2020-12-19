package subway.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        System.out.println(section);
        sections.add(section);
    }
}
