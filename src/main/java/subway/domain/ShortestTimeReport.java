package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class ShortestTimeReport {
    private DijkstraShortestPath dijkstraShortestTime;
    private GraphPath paths;

    public ShortestTimeReport(WeightedMultigraph<Station, DefaultWeightedEdge> stationTime) {
        this.dijkstraShortestTime = new DijkstraShortestPath(stationTime);
    }

    public void makePaths(Station startStation, Station finishStation){
        this.paths = dijkstraShortestTime.getPath(startStation, finishStation);
    }

    public int calculateTotalTime() {
        return (int) paths.getWeight();
    }

    public List<Station> makeStations() {
        return paths.getVertexList();
    }

    public int calculateTotalLength() {
        int totalLength = 0;
        List<Station> stations = this.makeStations();
        for (int i = 0; i < stations.size() - 1; i++) {
            int dfs = SubwayLengthRepository.getEdgeWeightWithTwoStations(stations.get(i), stations.get(i + 1));
            totalLength += dfs;
        }
        return totalLength;
    }

}
