package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayGraph {
    WeightedMultigraph<Station, DefaultWeightedEdge> distanceWeightGraph;
    WeightedMultigraph<Station, DefaultWeightedEdge> timeWeightGraph;

    public SubwayGraph() {
        this.distanceWeightGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        this.timeWeightGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getDistanceWeightGraph() {
        return distanceWeightGraph;
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getTimeWeightGraph() {
        return timeWeightGraph;
    }

    public void addVertices(List<Station> stations) {
        for (Station station : stations) {
            distanceWeightGraph.addVertex(station);
            timeWeightGraph.addVertex(station);
        }
    }

    public void setEdgeWeight(List<Edge> edges) {
        for (Edge edge : edges){
            setEdgeWeight(edge);
        }
    }

    private void setEdgeWeight(Edge edge) {
        distanceWeightGraph.setEdgeWeight(distanceWeightGraph.addEdge(edge.getFrom(), edge.getTo()), edge.getDistance());
        timeWeightGraph.setEdgeWeight(distanceWeightGraph.addEdge(edge.getFrom(), edge.getTo()), edge.getTime());
    }
}
