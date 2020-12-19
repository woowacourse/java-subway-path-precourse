package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;

public class SubwayAgency {
    private static final int ZERO = 0;
    private SubwayMap subwayMap;

    public SubwayAgency(SubwayMap subwayMap) {
        this.subwayMap = subwayMap;
    }

    public GraphResult getResultByDistance(StationBetween stationBetween) {
        DijkstraShortestPath<Station, DefaultWeightedEdge> pathByDistance
                = subwayMap.getPathByDistance();
        GraphPath<Station, DefaultWeightedEdge> path
                = pathByDistance.getPath(stationBetween.getStart(), stationBetween.getEnd());
        List<Station> stationList = path.getVertexList();
        int distance = (int) path.getWeight();
        int time = getTotalTime(stationList, Weight.TIME);
        return new GraphResult(stationList, distance, time);
    }

    private int getTotalTime(List<Station> stationList, Weight weight) {
        int result = 0;
        for (int i = 1; i < stationList.size(); i++) {
            int before = i - 1;
            result += getEachWeight(stationList.get(before), stationList.get(i), weight);
        }
        return result;
    }

    private int getEachWeight(Station start, Station end, Weight weight) {
        return LineRepository.lines()
                .stream()
                .filter(line -> line.containsPath(start, end))
                .mapToInt(line -> line.getWeight(start, end, weight))
                .findFirst()
                .orElse(ZERO);
    }
}
