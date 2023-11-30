package subway.service;

import subway.domain.Line;
import subway.domain.RouteInfo;
import subway.repository.LineRepository;

public class LineService {
    private final LineRepository lineRepository;

    private LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public static LineService createLineService(LineRepository lineRepository) {
        return new LineService(lineRepository);
    }

    public void registerLine() {
        for (RouteInfo routeInfo : RouteInfo.values()) {
            lineRepository.addLine(new Line(routeInfo.name()));
        }
    }
}
