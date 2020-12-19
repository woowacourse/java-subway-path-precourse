package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static int getSectionValue(String startStationName,String endStationName) {
        //구간의 시간 합을 구합니다.
        return
            SectionRepository
            .sections()
            .stream()
            .filter(section -> section.getUpStation().equals(startStationName))
            .filter(section -> section.getUpStation().equals(endStationName))
            .collect(Collectors.toList())
            .get(0)
            .getTime();





    }

}
