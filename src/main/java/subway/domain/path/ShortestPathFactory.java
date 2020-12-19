package subway.domain.path;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.weight.WeightRepository;
import subway.domain.weight.WeightType;

public class ShortestPathFactory {
    private static WeightedMultigraph<String, DefaultWeightedEdge> graph;
    private static WeightType type;

    public static DijkstraShortestPath getShortestPath(WeightType type) {
        graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        setVertexStations();
        setEdgeWeights();
        return new DijkstraShortestPath(graph);
    }

    private static void setVertexStations() {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
    }

    private static void setEdgeWeights() {
        for (Line line : LineRepository.lines()) {
            setEdgeWeightsForLine(line.getStations());
        }
    }
    
    private static void setEdgeWeightsForLine(List<String> stations) {
        for (int i = 0; i < stations.size() - 1; i++) {
            String firstStation = stations.get(i);
            String secondStation = stations.get(i + 1);
            double weight = WeightRepository.getWeight(firstStation, secondStation, type);
            graph.setEdgeWeight(graph.addEdge(firstStation, secondStation), weight);
        } 
    }
}
