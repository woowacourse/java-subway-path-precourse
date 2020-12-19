package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    public static final String DUPLICATE_LINE_ERROR = "해당 노선은 이미 등록되어 있습니다.";

    public static final String NOT_FOUND_STATION_ERROR = "해당 노선은 존재하지 않습니다.";

    private final List<Line> lines;

    public LineRepository() {
        this.lines = new LinkedList<>();
    }

    public LineRepository(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public LineRepository addLines(String... lineNames) {
        LineRepository lineRepository = new LineRepository();

        for (String lineName : lineNames) {
            lineRepository.addLine(new Line(lineName, null));
        }

        return lineRepository;
    }

    public LineRepository addLine(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException(DUPLICATE_LINE_ERROR);
        }

        lines.add(line);

        return new LineRepository(lines);
    }

    public LineRepository deleteLineByName(String name) {
        boolean removed = lines.removeIf(line -> Objects.equals(line.getName(), name));

        if (!removed) {
            throw new IllegalArgumentException(NOT_FOUND_STATION_ERROR);
        }

        return new LineRepository(lines);
    }

    public LineRepository deleteAll() {
        lines.clear();

        return new LineRepository(lines);
    }
}
