package subway.domain.line;

import java.util.List;

public class LineService {
    private static final String NOT_EXISTS_LINE_MESSAGE = "존재하지 않은 노선입니다.";
    private static final String ALREADY_EXISTS_LINE_MESSAGE = "이미 등록되어있는 노선입니다.";

    public Line findOneByName(String name) {
        return LineRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_LINE_MESSAGE));
    }

    public List<Line> findAll() {
        return LineRepository.lines();
    }

    public void addLine(LineDTO lineDTO) {
        Line line = new Line(lineDTO.getName());
        if (LineRepository.exists(line)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_LINE_MESSAGE);
        }
        LineRepository.addLine(line);
    }

    public void deleteAll() {
        LineRepository.deleteAll();
    }
}
