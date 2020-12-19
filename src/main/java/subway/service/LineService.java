package subway.service;

import java.util.NoSuchElementException;
import subway.domain.Line;
import subway.domain.LineRepository;

public class LineService {

    public static Line findLineByName(String name) {
        try {
            return LineRepository.lines().stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .get();
        } catch (NoSuchElementException e){
            throw new IllegalArgumentException("해당 지하철 노선이 존재하지 않습니다.");
        }
    }
}
