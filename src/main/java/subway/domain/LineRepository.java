package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    private LineRepository() {
    }

    public static void initLineRepository() {
        addLine(Line.newLineWithName("2호선"));
        addLine(Line.newLineWithName("3호선"));
        addLine(Line.newLineWithName("신분당선"));
    }

    public static List<Line> lines() {
        validateEmpty();
        return Collections.unmodifiableList(lines);
    }

    private static void validateEmpty() {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("등록되어 있는 지하철 노선이 없습니다.");
        }
    }

    public static void addLine(Line line) {
        validateDuplicate(line);
        lines.add(line);
    }

    private static void validateDuplicate(Line line) {
        if (lines.stream().anyMatch(l -> l.getName().equals(line.getName()))) {
            throw new IllegalArgumentException("이미 같은 이름의 지하철 노선이 등록되어 있습니다.");
        }
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
