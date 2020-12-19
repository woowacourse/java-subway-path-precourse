package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class ShortestLengthReport {
    private DijkstraShortestPath dijkstraShortestLength;
    private GraphPath paths;

    public ShortestLengthReport(WeightedMultigraph<Station, DefaultWeightedEdge> stationTime) {
        this.dijkstraShortestLength = new DijkstraShortestPath(stationTime);
    }

    public void makePaths(Station startStation, Station finishStation){
        try {
            this.paths = dijkstraShortestLength.getPath(startStation, finishStation);
        }catch (IllegalArgumentException e){
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
        int totalTime = 0;
        List<Station> stations = this.makeStations();
        for (int i = 0; i < stations.size() - 1; i++) {
            int dfs = SubwayTimeRepository.getEdgeWeightWithTwoStations(stations.get(i), stations.get(i + 1));
            totalTime += dfs;
        }
        return totalTime;
    }

}
