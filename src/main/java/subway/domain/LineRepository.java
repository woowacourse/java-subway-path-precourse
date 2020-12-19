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

    public static Line findByName(String name) {
        return lines.stream().filter(station -> station.getName().equals(name)).findFirst().get();
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void addSectionInLine(Line line, Section section) {
        findByName(line.getName()).addSection(section);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
