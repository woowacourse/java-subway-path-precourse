package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    private static void validateLineNameDuplicate(String lineName) throws IllegalArgumentException {
        if (lines.stream().anyMatch(line -> line.getName().equals(lineName))) {
            throw new IllegalArgumentException();
        }
    }

    public static void addLine(Line line) throws IllegalArgumentException {
        validateLineNameDuplicate(line.getName());
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
