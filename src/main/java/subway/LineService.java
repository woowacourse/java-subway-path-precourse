package subway;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineService {

    public static void addLine(String name) {
        Line line = new Line(name);
        LineRepository.addLine(line);
    }
}
