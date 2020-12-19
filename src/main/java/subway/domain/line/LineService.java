package subway.domain.line;

import subway.domain.line.dto.LineSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.LineException;

public class LineService {
    public LineService() {
    }

    public Line saveLine(LineSaveReqDto saveReqDto) {
        try {
            LineRepository.findByName(saveReqDto.getName());
        } catch (LineException lineException) {
            Line line = new Line(saveReqDto.getName());
            LineRepository.addLine(line);
            return line;
        }
        throw new LineException(ErrorCode.LINE_ALREADY_EXIST);
    }
}
