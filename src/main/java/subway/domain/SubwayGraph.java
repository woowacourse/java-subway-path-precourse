package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayGraph {
    public static final WeightedMultigraph<Station, DefaultWeightedEdge> distanceWeightGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    public static final WeightedMultigraph<Station, DefaultWeightedEdge> timeWeightGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static void addVertices(List<Station> stations) {
        for (Station station : stations) {
            distanceWeightGraph.addVertex(station);
            timeWeightGraph.addVertex(station);
        }
    }

    public static void setEdgeWeight(List<Edge> edges) {
        for (Edge edge : edges){
            setEdgeWeight(edge);
        }
    }

    private static void setEdgeWeight(Edge edge) {
        distanceWeightGraph.setEdgeWeight(distanceWeightGraph.addEdge(edge.getFrom(), edge.getTo()), edge.getDistance());
        timeWeightGraph.setEdgeWeight(distanceWeightGraph.addEdge(edge.getFrom(), edge.getTo()), edge.getTime());
    }

    public static List<Station> getTimeShortestPath(Station from, Station to) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeWeightGraph);
        return dijkstraShortestPath.getPath(from, to).getVertexList();
    }

    public static List<Station> getDistanceShortestPath(Station from, Station to) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceWeightGraph);
        return dijkstraShortestPath.getPath(from, to).getVertexList();
    }
}
