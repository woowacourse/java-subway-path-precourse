package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.line.Line;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    static {    //샘플 데이터
        new SectionRepository();
    }


    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public Line findByName(String name) {
        return lines.stream()
            .filter(line -> line.isMatchName(name))
            .findFirst()
            .orElseThrow(() -> {
                throw new IllegalArgumentException("[ERROR] 해당 이름의 노선은 존재하지 않습니다.");
            });
    }


    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}
