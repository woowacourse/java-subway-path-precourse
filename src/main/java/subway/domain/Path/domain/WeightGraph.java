package subway.domain.Path.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.domain.Station;

public class WeightGraph {

    private final WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public DefaultWeightedEdge addEdge(Station sourceStation, Station targetStation, double weight) {
        graph.addVertex(targetStation);
        DefaultWeightedEdge edge = graph.addEdge(sourceStation, targetStation);
        graph.setEdgeWeight(edge, weight);

        return edge;
    }

    public void addVertex(Station station) {
        graph.addVertex(station);
    }

    public double getEdgeWeight(DefaultWeightedEdge edge) {
        return graph.getEdgeWeight(edge);
    }

    public void setEdgeWeight(DefaultWeightedEdge edge, double weight) {
        graph.setEdgeWeight(edge, weight);
    }

    public DijkstraShortestPath getDijkstraShortestPath() {
        return new DijkstraShortestPath(graph);
    }
}
