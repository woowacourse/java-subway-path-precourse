package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    List<Station> stationList = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Station... stations) {
        this.name = name;
        for (int i = 0; i < stations.length; i++) {
            stationList.add(stations[i]);
        }
    }

    public String getName() {
        return name;
    }
}
