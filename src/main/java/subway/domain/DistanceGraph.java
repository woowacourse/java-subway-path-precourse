package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceGraph {
    public static DijkstraShortestPath dijkstraShortestPath;

    public static void init() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

        for(Line line : LineRepository.lines()) {
            List<Station> stations = line.getStations();
            for(int i = 1; i < stations.size(); i++) {
                graph.addVertex(stations.get(i - 1).getName());
                graph.addVertex(stations.get(i).getName());
                graph.setEdgeWeight(graph.addEdge(stations.get(i).getName(), stations.get(i - 1).getName()), stations.get(i).getDistance());
            }
        }
        dijkstraShortestPath  = new DijkstraShortestPath(graph);
    }

    public static List<String> getPath(String start, String end) {
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }
}