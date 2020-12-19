package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private static final String LINE_NOT_FOUND_WARN = "해당 노선이 존재하지 않습니다.";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static Line findLineByName(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LINE_NOT_FOUND_WARN));
    }
}
