package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static List<Line> findLinesContainStation(Station station) {
        return lines.stream().filter(line -> line.haveStation(station)).collect(Collectors.toList());
    }
//TODO 하나만 찾는 라인
    public static Line findLineContainStation(Station station) {
        return lines.stream().filter(line -> line.haveStation(station)).findAny().get();
    }

    public static boolean isNotTerminal(Station station) {
        return lines.stream().noneMatch(line -> line.getTerminals().contains(station));
    }
}
