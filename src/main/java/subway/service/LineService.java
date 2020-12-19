package subway.service;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;

public class LineService {
    LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public void add(Line line) {
        lineRepository.save(line);
    }
}
