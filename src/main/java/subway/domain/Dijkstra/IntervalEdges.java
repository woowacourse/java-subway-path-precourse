package subway.domain.Dijkstra;

import exception.SubwayMapException;
import java.util.ArrayList;
import java.util.List;
import subway.domain.StationRepository;

public class IntervalEdges {
    private static final String NOT_EXIST_ROUTE = "두 역 사이에 구간이 존재하지 않습니다.";
    private static final int START_INDEX = 0;
    private List<IntervalEdge> intervalEdges = new ArrayList<>();
    private List<Station> stations = new ArrayList<>();

    public IntervalEdges() {
        this.intervalEdges = intervalEdges;
    }

    public IntervalEdge findByStations(Station source, Station Destination) throws SubwayMapException {
        return intervalEdges.stream()
                            .filter(intervalEdge -> intervalEdge.getStart() == source && intervalEdge.getEnd() == Destination)
                            .findFirst()
                            .orElseThrow(() -> new SubwayMapException(NOT_EXIST_ROUTE));
    }

    public int totalTimeTaken() {
        int totalTime = 0;
        for(IntervalEdge intervalEdge: intervalEdges) {
            totalTime += intervalEdge.getCost().getTime();
        }
        return totalTime;
    }

    public int totalDistanceTaken() {
        int totalDistance= 0;
        for(IntervalEdge intervalEdge: intervalEdges) {
            totalDistance += intervalEdge.getCost().getTime();
        }
        return totalDistance;
    }

    public void updateStations() {
        stations.add(intervalEdges.get(START_INDEX).getStart());
        for(IntervalEdge intervalEdge: intervalEdges) {
            stations.add(intervalEdge.getEnd());
        }
    }

    public List<Station> getStations() {
        updateStations();
        return stations;
    }

}
