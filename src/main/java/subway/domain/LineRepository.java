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

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static void addAll(List<Line> newLines) {
        lines.addAll(newLines);
    }

    public static boolean isOnSameLine(String startStation, String endStation) {
        for (Line line : lines) {
            if (line.hasStation(startStation) && line.hasStation(endStation)) {
                return true;
            }
        }
        return false;
    }
}
