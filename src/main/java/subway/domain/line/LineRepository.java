package subway.domain.line;

import subway.exception.line.DuplicateLineNameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void save(Line line) {
        if (lines.contains(line)) {
            throw new DuplicateLineNameException(line.getName());
        }

        lines.add(line);
    }

    public static void saveAll(List<Line> lines) {
        lines.forEach(LineRepository::save);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
