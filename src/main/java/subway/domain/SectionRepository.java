package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import subway.message.ErrorMessage;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    private static void validateSectionLineNameDuplicate(String lineName)
        throws IllegalArgumentException {
        if (sections.stream().anyMatch(section -> section.getLine().getName().equals(lineName))) {
            throw new IllegalArgumentException(
                ErrorMessage.SECTION_REPOSITORY_LINE_ALREADY_EXIST.toString()
            );
        }
    }

    public static void addSection(Section section) throws IllegalArgumentException {
        validateSectionLineNameDuplicate(section.getLine().getName());
        sections.add(section);
    }

    public static void addSectionByNames(String lineName, String[] stationNames, List<Gap> gaps)
        throws IllegalArgumentException {
        LineRepository.validateLineNameDuplicate(lineName);
        final Line sectionLine = LineRepository.lines().stream()
            .filter(line -> line.getName().equals(lineName)).findFirst().get();
        final List<Station> stations = new LinkedList<>();
        Arrays.stream(stationNames).forEach(stationName -> {
            StationRepository.validateStationNameDuplicate(stationName);
            stations.add(StationRepository.stations().stream()
                .filter(station -> station.getName().equals(stationName)).findFirst().get());
        });
        addSection(new Section(sectionLine, stations, gaps));
    }

    public static boolean deleteSectionByLineName(String lineName) {
        return sections.removeIf(section -> Objects.equals(section.getLine().getName(), lineName));
    }

    public static void deleteAll() {
        sections.clear();
    }
}
