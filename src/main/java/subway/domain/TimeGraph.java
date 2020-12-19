package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

import static subway.utils.Constant.FOR_LOOF_INDEX_ONE;

public class TimeGraph {
    public static DijkstraShortestPath dijkstraShortestPath;

    public static void init() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Line line : LineRepository.lines()) {
            List<Station> stations = line.getStations();
            for (int i = FOR_LOOF_INDEX_ONE; i < stations.size(); i++) {
                graph.addVertex(stations.get(i - FOR_LOOF_INDEX_ONE).getName());
                graph.addVertex(stations.get(i).getName());
                graph.setEdgeWeight(graph.addEdge(stations.get(i).getName(), stations.get(i - FOR_LOOF_INDEX_ONE).getName()), stations.get(i).getTime());
            }
        }
        dijkstraShortestPath = new DijkstraShortestPath(graph);
    }

    public static List<String> getPath(String start, String end) {
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }
}