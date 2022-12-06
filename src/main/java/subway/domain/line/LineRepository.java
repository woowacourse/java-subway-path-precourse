package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.domain.util.SetupConstant.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    private LineRepository() {
    }

    public static void setUp() {
        addLine(new Line(LINE_2));
        addLine(new Line(LINE_3));
        addLine(new Line(LINE_SINBUNDANG));
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

    public static Line findByName(String name) {
        return lines.stream()
                .filter(line -> line.nameEquals(name))
                .findAny()
                .orElse(null);
    }

}
