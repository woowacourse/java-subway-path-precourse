package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;

public class LineService {
    public static void addLine(String lineName) {
        Line line = new Line(lineName);
        LineRepository.addLine(line);
    }
}
