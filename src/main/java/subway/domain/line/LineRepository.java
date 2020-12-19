package subway.domain.line;

import subway.utils.exception.InvalidSequnceLineException;
import subway.utils.exception.NotSameLineException;

import java.util.*;

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

    private static Optional<Line> findLine(String firstStation, String lastStation) {
        return lines.stream()
                .filter(line -> line.contains(firstStation) && line.contains(lastStation))
                .findAny();
    }

    public static void sameLine(String firstStation, String lastStation) {
        findLine(firstStation, lastStation)
                .orElseThrow(() -> new NotSameLineException());
    }

    public static void invalidSequence(String firstStation, String lastStation) {
        lines.stream()
                .filter(line -> line.contains(firstStation) && line.contains(lastStation) && line.validSequence(firstStation, lastStation))
                .findAny()
                .orElseThrow(() -> new InvalidSequnceLineException());
    }

    public static String findSelectLine(String firstStation, String lastStation) {
        return findLine(firstStation, lastStation)
                .get()
                .getName();
    }
}