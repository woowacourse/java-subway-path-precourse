package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    private static void validateSectionLineNameDuplicate(String lineName)
        throws IllegalArgumentException {
        if (sections.stream().anyMatch(section -> section.getLine().getName().equals(lineName))) {
            throw new IllegalArgumentException();
        }
    }

    public static void addSection(Section section) throws IllegalArgumentException {
        validateSectionLineNameDuplicate(section.getLine().getName());
        sections.add(section);
    }

    private static Line getLineFromOptional(Optional<Line> optionalLine)
        throws IllegalArgumentException {
        if (optionalLine.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalLine.get();
    }

    private static Station getStationFromOptional(Optional<Station> optionalStation)
        throws IllegalArgumentException {
        if (optionalStation.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalStation.get();
    }

    public static void addSectionByNames(String lineName, String[] stationNames, List<Gap> gaps)
        throws IllegalArgumentException {
        final Line sectionLine = getLineFromOptional(LineRepository.getLineByName(lineName));
        final List<Station> stations = new LinkedList<>();
        Arrays.stream(stationNames).forEach(stationName ->
            stations.add(getStationFromOptional(StationRepository.getStationByName(stationName)))
        );
        addSection(new Section(sectionLine, stations, gaps));
    }

    public static boolean deleteSectionByLineName(String lineName) {
        return sections.removeIf(section -> Objects.equals(section.getLine().getName(), lineName));
    }

    public static void deleteAll() {
        sections.clear();
    }
}
