package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public static Line getLineByName(String name) {
        Optional<Line> optional = lines.stream().filter(it -> it.getName() == name).findFirst();
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    public static void deleteAll() {
        lines.clear();
    }
}
