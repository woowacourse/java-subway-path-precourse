package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {

    static List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }

}
