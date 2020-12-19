package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class ShortestTimeReport {
    public static final int ALL_STATIONS_ADD_HELPER = 1;
    public static final int INIT_LENGTH = 0;

    private DijkstraShortestPath dijkstraShortestTime;
    private GraphPath paths;

    public ShortestTimeReport(WeightedMultigraph<Station, DefaultWeightedEdge> stationTime) {
        this.dijkstraShortestTime = new DijkstraShortestPath(stationTime);
    }

    public void makePaths(Station startStation, Station finishStation) {
        try {
            this.paths = dijkstraShortestTime.getPath(startStation, finishStation);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("역이 연결되어 있지 않습니다.");
        }
    }

    public int calculateTotalTime() {
        return (int) paths.getWeight();
    }

    public List<Station> makeStations() {
        return paths.getVertexList();
    }

    public int calculateTotalLength() {
        int totalLength = INIT_LENGTH;
        List<Station> stations = this.makeStations();
        for (int i = 0; i < stations.size() - ALL_STATIONS_ADD_HELPER; i++) {
            int dfs = SubwayLengthRepository.getEdgeWeightWithTwoStations(stations.get(i), stations.get(i + ALL_STATIONS_ADD_HELPER));
            totalLength += dfs;
        }
        return totalLength;
    }

}
