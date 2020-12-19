package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String NOT_FOUND_ERROR_MESSAGE = "해당 역이 존재하지 않습니다.";

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void addStation(String name, Station station) {
        Line line = selectByName(name);
        line.addStation(station);
    }

    public static Line selectByName(String name) {
        return lines.stream()
                .filter(line -> line.isMatchedName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR_MESSAGE));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static boolean isExistent(String name) {
        return lines.stream()
                .anyMatch(line -> line.isMatchedName(name));
    }
}
