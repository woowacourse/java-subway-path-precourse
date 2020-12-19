package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static void addLine(Line line) {
        lines.add(line);
    }
}
