package subway.presentation;

import subway.domain.line.LineDTO;
import subway.domain.line.LineService;

public class LineController {
    private final LineService lineService = new LineService();

    public void addLine(String lineName) {
        LineDTO lineDTO = new LineDTO(lineName);
        this.lineService.addLine(lineDTO);
    }
}
