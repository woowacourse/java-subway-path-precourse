package subway.domain.Dijkstra;

import org.jgrapht.graph.WeightedMultigraph;

public class RouteMap {
    private WeightedMultigraph<Station, Interval> graph = new WeightedMultigraph(Interval.class);

    public RouteMap() {

    }

    public void addStation(Station station) {
        graph.addVertex(station);
    }

    public void addEdge(Station source, Station destination, int weight) {
        graph.setEdgeWeight(graph.addEdge(source, destination), weight);
    }

    public WeightedMultigraph<Station, Interval> getGraph() {
        return graph;
    }

}
