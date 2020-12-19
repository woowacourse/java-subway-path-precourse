package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static List<Station> getAnotherStationList(Station station) {
        List<Station> stationList = new ArrayList<>();
        sections.stream()
                .filter(section -> section.getStations().contains(station))
                .forEach(section -> stationList.add(section.getAnotherStation(station)));
        return stationList;
    }

//    public static Section getSectionByFromTo(Station from, Station to) {
//        return sections.stream()
//                .filter(section -> section.)
//    }

}
