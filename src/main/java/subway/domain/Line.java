package subway.domain;

import exception.NoExistStationException;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private WeightedMultigraph<String, DefaultWeightedEdge> time = new WeightedMultigraph(DefaultWeightedEdge.class);
    private WeightedMultigraph<String, DefaultWeightedEdge> length = new WeightedMultigraph(DefaultWeightedEdge.class);

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addLineStation(String station) {
        time.addVertex(station);
        length.addVertex(station);
    }

    public void addInformation(String first, String second, int time, int length) {
        validateStation(first);
        validateStation(second);
        this.time.setEdgeWeight(this.time.addEdge(first, second), time);
        this.length.setEdgeWeight(this.length.addEdge(first, second), length);
    }

    private void validateStation(String name) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(name)) {
                return;
            }
        }
        throw new NoExistStationException();
    }

    public List<String> calculateLength(String start, String end) {
        List<String> result = new ArrayList<>();
        if (length.containsVertex(start) && length.containsVertex(end)) {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(length);
            if (!dijkstraShortestPath.getPath(start, end).getVertexList().isEmpty()) {
                result = dijkstraShortestPath.getPath(start, end).getVertexList();
            }
        }
        return result;
    }

    public List<String> calculateTime(String start, String end) {
        List<String> result = new ArrayList<>();
        if (length.containsVertex(start) && length.containsVertex(end)) {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(time);
            if (!dijkstraShortestPath.getPath(start, end).getVertexList().isEmpty()) {
                result = dijkstraShortestPath.getPath(start, end).getVertexList();
            }
        }
        return result;
    }

    public int getLength(String start, String end) {
        if (length.containsVertex(start) && length.containsVertex(end)) {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(length);
            return (int) dijkstraShortestPath.getPath(start, end).getWeight();
        }
        return 100;
    }

    public int getTime(String start, String end) {
        if (length.containsVertex(start) && length.containsVertex(end)) {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(time);
            return (int) dijkstraShortestPath.getPath(start, end).getWeight();
        }
        return 100;
    }
}
