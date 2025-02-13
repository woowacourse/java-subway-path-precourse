package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static Optional<Line> findByName(String name) {
        return lines.stream().filter(line -> line.getName().equals(name)).findFirst();
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

    public static boolean exists(Line other) {
        return lines.stream().anyMatch(line -> line.getName().equals(other.getName()));
    }
}
