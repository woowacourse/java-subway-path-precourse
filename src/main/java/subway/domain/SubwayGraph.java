package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.*;

public class SubwayGraph {
    private static final int 다음역 = 1;
    private Graph<Station, Integer> subwayGraph;


    public SubwayGraph() {
    }

    public void setSubwayGraphByDistance() {
        for (Line line : LineRepository.lines()) {
            for (Station station : line.getLineStations()) {
                subwayGraph.addVertex(station);
            }

            for (int i = 0; i < line.getLineStations().size(); i++) {
                subwayGraph.setEdgeWeight(line.getLineStations().get(i), line.getLineStations().get(i + 1), line.getLineDistances().get(i).getDistance()); // 거리로
            }
        }
    }

    public void setSubwayGraphByTime() {
        for (Line line : LineRepository.lines()) {
            for (Station station : line.getLineStations()) {
                subwayGraph.addVertex(station);
            }

            for (int i = 0; i < line.getLineStations().size() - 다음역; i++) {
                subwayGraph.setEdgeWeight(line.getLineStations().get(i), line.getLineStations().get(i + 다음역), line.getLineDistances().get(i).getTime()); // 시간으로
            }
        }
    }

    public List<Station> getShortestPath(Station startStation, Station endStation) {

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(subwayGraph);
        List<Station> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();

        return shortestPath;
    }

}
