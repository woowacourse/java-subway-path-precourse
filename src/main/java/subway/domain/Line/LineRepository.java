package subway.domain.Line;

import subway.exception.LineNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineRepository {
    private final List<Line> lines = new ArrayList<>();

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void save(Line line) {
        lines.add(line);
    }

    public Line findByName(String name) {
        return lines.stream()
                .filter(line -> line.isSameName(name))
                .findAny()
                .orElseThrow(LineNotFoundException::new);
    }

    public List<Line> findAll() {
        return Collections.unmodifiableList(lines);
    }

    public boolean delete(Line targetLine) {
        return lines.removeIf(line -> line.equals(targetLine));
    }
}
