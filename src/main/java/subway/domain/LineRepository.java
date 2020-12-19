package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        InitialSubway.initializeLines();
        InitialSubway.initializeSections();
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static Line getLine(String lineName) throws IllegalArgumentException {
        return LineRepository
                .lines()
                .stream()
                .filter(line -> line.getName().equals(lineName))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
