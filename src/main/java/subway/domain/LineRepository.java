package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.common.ErrorCustomException;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();
    private static final String FAIL_TO_FOUND_LINE = "노선을 찾지 못했습니다.";

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

//    public static Line findLineByName(String name) {
//        return lines.stream().filter(line -> Objects.equals(line.getName(), name)).findFirst()
//            .orElseThrow(() -> new ErrorCustomException(FAIL_TO_FOUND_LINE));
//    }
}
