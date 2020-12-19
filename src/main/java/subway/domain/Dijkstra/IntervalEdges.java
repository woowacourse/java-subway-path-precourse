package subway.domain.Dijkstra;

import exception.SubwayMapException;
import java.util.List;

public class IntervalEdges {
    private List<IntervalEdge> intervalEdges;
    private static final String NOT_EXIST_ROUTE = "두 역 사이에 경로가 존재하지 않습니다.";
    public IntervalEdges(List<IntervalEdge> intervalEdges) {

    }

    public IntervalEdge findByStations(Station source, Station Destination)
        throws SubwayMapException {
        return intervalEdges.stream()
                            .filter(intervalEdge -> intervalEdge.getStart() == source && intervalEdge.getEnd() == Destination)
                            .findFirst()
                            .orElseThrow(() -> new SubwayMapException(NOT_EXIST_ROUTE));
    }

}
