package subway.domain;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.*;

public class SubwayGraph {
    private static final int 다음역 = 1;
    private WeightedMultigraph<String, DefaultWeightedEdge> subwayGraph = new WeightedMultigraph(DefaultWeightedEdge.class);


    public SubwayGraph() {
    }

    public void setSubwayGraphByDistance() {
        for (Line line : LineRepository.lines()) {
            for (Station station : line.getLineStations()) {
                subwayGraph.addVertex(station.getName());
            }

            for (int i = 0; i < line.getLineStations().size() - 다음역; i++) {
                subwayGraph.setEdgeWeight(subwayGraph.addEdge(line.getLineStations().get(i).getName(), line.getLineStations().get(i + 1).getName()), line.getLineDistances().get(i).getDistance()); // 거리로
            }
        }
    }

    public void setSubwayGraphByTime() {
        for (Line line : LineRepository.lines()) {
            for (Station station : line.getLineStations()) {
                subwayGraph.addVertex(station.getName());
            }

            for (int i = 0; i < line.getLineStations().size() - 다음역; i++) {
                subwayGraph.setEdgeWeight(subwayGraph.addEdge(line.getLineStations().get(i).getName(), line.getLineStations().get(i + 다음역).getName()), line.getLineDistances().get(i).getTime()); // 시간으로
            }
        }
    }

    public List<String> getShortestPath(Station startStation, Station endStation) {
        try {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(subwayGraph);
            List<String> shortestPath = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName()).getVertexList();

            return shortestPath;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 두 역이 연결되어있지 않습니다.");
        }

    }

}
