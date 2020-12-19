package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineService {

    public static Line findLineByName(String name) {
        return LineRepository.lines().stream()
            .filter(line -> line.getName().equals(name))
            .findAny()
            .get();
    }
}
