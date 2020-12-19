package subway.line;

import java.util.List;

public class LineService {
    public void addAllLine(List<Line> lines) {
        for (Line line : lines) {
            LineRepository.addLine(line);
        }
    }

    public List<Line> findAllLine() {
        return LineRepository.lines();
    }
}
