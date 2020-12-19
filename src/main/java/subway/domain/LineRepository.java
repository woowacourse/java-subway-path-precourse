package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String LINE_NOT_FOUND_WARN = "[ERROR] 해당 노선이 존재하지 않습니다.";
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

    public static Line findLineByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LINE_NOT_FOUND_WARN));
    }
}
