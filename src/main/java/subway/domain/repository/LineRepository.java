package subway.domain.repository;

import subway.domain.entity.Line;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

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

    public static Optional<Line> findByName(String name) {
        return lines.stream()
                .filter(line -> line.matchesName(name))
                .findFirst();
    }
}
