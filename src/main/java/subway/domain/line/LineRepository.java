package subway.domain.line;

import subway.utils.exception.InvalidSequnceLineException;
import subway.utils.exception.NotSameLineException;

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

    public static void sameLine(String firstStation, String lastStation) {
        lines.stream()
                .filter(line -> line.contains(firstStation) && line.contains(lastStation))
                .findAny()
                .orElseThrow(() -> new NotSameLineException());
    }

    public static void invalidSequence(String firstStation, String lastStation) {
        lines.stream()
                .filter(line -> line.contains(firstStation) && line.contains(lastStation) && line.validSequence(firstStation, lastStation))
                .findAny()
                .orElseThrow(() -> new InvalidSequnceLineException());
    }
}
