package subway.domain.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        addLine(Line.createWithInitialStations(
                "2호선", 
                Arrays.asList("교대역", "강남역", "역삼역")));
        addLine(Line.createWithInitialStations(
                "3호선", 
                Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")));
        addLine(Line.createWithInitialStations(
                "신분당선", 
                Arrays.asList("강남역", "양재역", "양재시민의숲역")));
    }

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
}
