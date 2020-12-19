package subway.controller;

import subway.domain.Edge;

import java.util.List;
import org.jgrapht.graph.WeightedMultigraph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Navigator {

    public WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;
    public WeightedMultigraph<String, DefaultWeightedEdge> timeGraph;

    public Navigator() {
        this.distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        this.timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    }

    public void addStation(String stationName) {
        distanceGraph.addVertex(stationName);
        timeGraph.addVertex(stationName);
    }

    public void addEdge(String startStation, String endStation, Edge edge) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(startStation, endStation), edge.distance);
        timeGraph.setEdgeWeight(timeGraph.addEdge(startStation, endStation), edge.time);
    }

    public List<String> searchShortestDistance(List<String> stations) {
        return stations;
    }

    public List<String> searchShortestTime(List<String> stations) {
        return stations;
    }
}
