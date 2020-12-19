package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;
    private WeightedMultigraph<Station, DefaultWeightedEdge> distancePath;
    private WeightedMultigraph<Station, DefaultWeightedEdge> timePath;

    public Line(String name) {
        this.name = name;
        this.stations = new ArrayList<>();
        this.distancePath = new WeightedMultigraph(DefaultWeightedEdge.class);
        this.timePath = new WeightedMultigraph(DefaultWeightedEdge.class);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        this.stations.add(station);
        this.distancePath.addVertex(station);
        this.timePath.addVertex(station);
    }

    public void addPathInformation(Station start, Station end, int distance, int time) {
        this.distancePath.setEdgeWeight(this.distancePath.addEdge(start, end), distance);
        this.timePath.setEdgeWeight(this.timePath.addEdge(start, end), time);
    }

    public double getTotalTime(Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(this.timePath);
        return dijkstraShortestPath.getPathWeight(start, end);
    }

    public double getTotalDistance(Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(this.distancePath);
        return dijkstraShortestPath.getPathWeight(start, end);
    }

    public List<String> getShortestDistancePath(Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(this.distancePath);
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }

    public List<String> getMinimumTimePath(Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(this.timePath);
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }

    public boolean hasTwoStations(Station start, Station end) {
        boolean startStation = this.stations.stream()
                .anyMatch(station -> station.getName().equals(start.getName()));

        boolean endStation = this.stations.stream()
                .anyMatch(station -> station.getName().equals(end.getName()));

        return startStation && endStation;
    }
}
