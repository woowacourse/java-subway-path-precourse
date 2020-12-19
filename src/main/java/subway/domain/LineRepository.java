package subway.domain;

import subway.exception.SubwayException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final String ERROR_NOT_FOUND_NAME_MSG = "해당 이름을 가진 노선이 없습니다.";

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
                .filter(line -> Objects.equals(line.getName(), name))
                .findAny()
                .orElseThrow(() -> new SubwayException(ERROR_NOT_FOUND_NAME_MSG));
    }
}
