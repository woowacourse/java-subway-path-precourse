package subway.domain;

import java.util.List;

public class LineFactory {
    public static Line createLine(String name, List<Station> sections) {
        return new Line(name, sections);
    }
}
