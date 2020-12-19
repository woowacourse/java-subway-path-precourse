package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.message.ErrorMessage;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void validateLineNameDuplicate(String lineName) throws IllegalArgumentException {
        if (lineNameExists(lineName)) {
            throw new IllegalArgumentException(
                ErrorMessage.LINE_REPOSITORY_LINE_ALREADY_EXIST.toString()
            );
        }
    }

    private static boolean lineNameExists(String name) {
        return lines.stream().anyMatch(line -> line.getName().equals(name));
    }

    public static void addLine(Line line) throws IllegalArgumentException {
        validateLineNameDuplicate(line.getName());
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
