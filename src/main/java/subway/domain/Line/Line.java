package subway.domain.Line;

import subway.domain.section.DistanceAndTime;
import subway.domain.section.Section;
import subway.domain.station.Station;
import subway.exception.LineNameFormatException;

import java.util.List;

public class Line {
    private static final String LINE = "선";
    private static final int LINE_NAME_LENGTH = 2;

    private String name;
    private Section section;

    public Line(String name, List<Station> sections, List<DistanceAndTime> distanceAndTimes) {
        validate(name);
        this.name = name;
        this.section = new Section(sections, distanceAndTimes);
    }

    private void validate(String name) {
        validateNameFormat(name);
        validateNameLength(name);
    }

    private void validateNameFormat(String name) {
        if (!name.endsWith(LINE)) {
            throw new LineNameFormatException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() - LINE.length() < LINE_NAME_LENGTH) {
            throw new LineNameFormatException();
        }
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }
    public String getName() {
        return name;
    }
}
