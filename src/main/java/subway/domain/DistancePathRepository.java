package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistancePathRepository {

    private Map<Line, WeightedMultigraph> paths = new HashMap<>();
    private WeightedMultigraph<String, DefaultWeightedEdge> graphs =
        new WeightedMultigraph(DefaultWeightedEdge.class);

    public void addNewLine(Line line, List<String> stations) {
        stations.stream().forEach(name -> graphs.addVertex(name));
        this.paths.put(line, graphs);
    }

    public void addEdgeWeight(Line line, Station startStation, Station endStation, int weight) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = paths.get(line);
        graph.setEdgeWeight(graph.addEdge(startStation.getName(), endStation.getName()), weight);
    }

    public List findStationToStation(Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graphs);
        return dijkstraShortestPath
            .getPath(startStation.getName(), endStation.getName())
            .getVertexList();
    }

    public int findValue(Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graphs);
        return (int) dijkstraShortestPath
            .getPath(startStation.getName(), endStation.getName())
            .getWeight();
    }

}
