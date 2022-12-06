package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineSectionRepository {
    private static final List<LineSection> lineSections = new ArrayList<>();

    private LineSectionRepository() {
    }

    public static LineSection findByLine(Line line) {
        return lineSections.stream()
                .filter(section -> section.lineEquals(line))
                .findAny()
                .orElse(null);
    }

    public static List<LineSection> findAll() {
        return Collections.unmodifiableList(lineSections);
    }

    public static LineSection findByStation(Station station) {
        return lineSections.stream()
                .filter(section -> section.containsStation(station))
                .findAny()
                .orElse(null);
    }

}
