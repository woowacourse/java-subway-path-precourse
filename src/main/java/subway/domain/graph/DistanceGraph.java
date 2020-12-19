package subway.domain.graph;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceGraph {
    private String line;
    WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public DistanceGraph(String line, List<String> stations) {
        this.line = line;
        stations.forEach(station -> graph.addVertex(station));
    }

    public static DistanceGraph valueOf(String line, List<String> stations) {
        return new DistanceGraph(line, stations);
    }

    public void setEge(String station, String nextStation, int distance) {
        graph.setEdgeWeight(graph.addEdge(station, nextStation), distance);
    }
}