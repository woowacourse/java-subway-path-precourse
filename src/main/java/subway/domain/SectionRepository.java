package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {
    private static final int NULL = 0;
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static int getTimeWeightByStationName(String from, String to) {
        for (Section section : sections) {
            if (section.hasStationName(from, to)) {
                return section.getTime();
            }
        }
        return NULL;
    }

    public static int getDistanceWeightByStationName(String from, String to) {
        for (Section section : sections) {
            if (section.hasStationName(from, to)) {
                return section.getDistance();
            }
        }
        return NULL;
    }
}
