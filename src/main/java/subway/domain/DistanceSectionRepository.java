package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistanceSectionRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public static void addSection(Station source, Station destination, Distance distance) {
        graph.addVertex(source.getName());
        graph.addVertex(destination.getName());
        graph.setEdgeWeight(graph
            .addEdge(source.getName(), destination.getName()), distance.getDistance());
    }

    public static List<String> getShortestPath(Station source, Station destination){
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(source.getName(), destination.getName()).getVertexList();
    }

    public static Distance getShortestDistance(Station source, Station destination){
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return Distance.newDistance((int)dijkstraShortestPath
            .getPathWeight(source.getName(), destination.getName()));
    }
}
