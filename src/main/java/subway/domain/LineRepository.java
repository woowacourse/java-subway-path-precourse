package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        checkOverlappedLine(line.getName());
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void checkOverlappedLine(String target) {
        if (isExistedLine(target)) {
            System.out.println();
            System.out.println(DomainErrorMessage.OVERLAP_LINE);
            throw new IllegalArgumentException(DomainErrorMessage.OVERLAP_LINE);
        }
    }

    public static boolean isExistedLine(String target) {
        long isOverlap = lines.stream()
                .filter(line -> line.compareName(target))
                .count();

        if (isOverlap == DomainConstant.ZERO_LONG_NUMBER) {
            return false;
        }

        return true;
    }

    public static void deleteAll() {
        lines.clear();
    }
}
