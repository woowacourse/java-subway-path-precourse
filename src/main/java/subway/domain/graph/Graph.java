package subway.domain.graph;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.Station;

public class Graph {

    private final WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public void updateGraph(Station station1, Station station2, int pathWeight) {
        if (!graph.containsVertex(station1))
            graph.addVertex(station1);
        if (!graph.containsVertex(station2))
            graph.addVertex(station2);
        graph.setEdgeWeight(graph.addEdge(station1, station2), pathWeight);
    }

}
