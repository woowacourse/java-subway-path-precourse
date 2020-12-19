package subway.domain.Dijkstra;

import java.util.List;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class RouteMap {
    private WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public RouteMap() {

    }

    public void addStation(Station station) {
        graph.addVertex(station);
    }

    public void addInterval(Station s1, Station s2, int weight) {
        graph.setEdgeWeight(graph.addEdge(s1, s2), weight);
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public Station getSourceStationOf(DefaultWeightedEdge edge) {
        return graph.getEdgeSource(edge);
    }

    public Station getDestinationStationOf(DefaultWeightedEdge edge) {
        return graph.getEdgeTarget(edge);
    }

}
