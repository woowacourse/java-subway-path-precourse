package subway.repository;

import subway.constant.InitialData;
import subway.domain.Line;

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

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static void initLines() {
        for (int i = 0; i < InitialData.lines.size(); i++) {
            addLine(InitialData.lines.get(i));
            InitialData.lines.get(i).addPaths(InitialData.linePaths.get(i));
        }
    }
}
