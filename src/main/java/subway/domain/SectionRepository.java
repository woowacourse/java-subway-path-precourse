package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {

    private static final List<Section> sectionList = new ArrayList<>();

    public static Section findByStation(Station fromStation, Station toStation) {
        return sectionList.stream().filter(section -> section.isSameSection(fromStation, toStation))
            .findFirst().get();
    }

    public static void addSection(Section section) {
        sectionList.add(section);
    }

    public static boolean isDuplicatedSection(Section section) {
        return sectionList.contains(section);
    }

}
