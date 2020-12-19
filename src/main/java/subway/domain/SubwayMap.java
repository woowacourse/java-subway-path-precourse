package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayMap {
    private final WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph;
    private final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph;

    public SubwayMap(List<Line> lines) {
        WeightedMultigraph<Station, DefaultWeightedEdge> time = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        for (Line line : lines) {
            line.addEdge(time, Weight.TIME);
            line.addEdge(graph, Weight.DISTANCE);
        }
        this.timeGraph = time;
        this.distanceGraph = graph;
    }

    public DijkstraShortestPath<Station, DefaultWeightedEdge> getPathByTime() {
        DijkstraShortestPath<Station, DefaultWeightedEdge> result = new DijkstraShortestPath<>(timeGraph);
        return result;
    }

    public DijkstraShortestPath<Station, DefaultWeightedEdge> getPathByDistance() {
        DijkstraShortestPath<Station, DefaultWeightedEdge> result = new DijkstraShortestPath<>(distanceGraph);
        return result;
    }
}
