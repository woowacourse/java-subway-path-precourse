package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

import static subway.domain.ShortestTimeReport.ALL_STATIONS_ADD_HELPER;
import static subway.domain.ShortestTimeReport.INIT_LENGTH;

public class ShortestLengthReport {
    private DijkstraShortestPath dijkstraShortestLength;
    private GraphPath paths;

    public ShortestLengthReport(WeightedMultigraph<Station, DefaultWeightedEdge> stationTime) {
        this.dijkstraShortestLength = new DijkstraShortestPath(stationTime);
    }

    public void makePaths(Station startStation, Station finishStation) {
        try {
            this.paths = dijkstraShortestLength.getPath(startStation, finishStation);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("역이 연결되어 있지 않습니다.");
        }
    }

    public int calculateTotalLength() {
        return (int) paths.getWeight();
    }

    public List<Station> makeStations() {
        return paths.getVertexList();
    }

    public int calculateTotalTime() {
        int totalTime = INIT_LENGTH;
        List<Station> stations = this.makeStations();
        for (int i = 0; i < stations.size() - ALL_STATIONS_ADD_HELPER; i++) {
            int dfs = SubwayTimeRepository.getEdgeWeightWithTwoStations(stations.get(i), stations.get(i + ALL_STATIONS_ADD_HELPER));
            totalTime += dfs;
        }
        return totalTime;
    }

}
