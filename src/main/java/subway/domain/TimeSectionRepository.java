package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimeSectionRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public static void addSection(Station source, Station destination, Time time) {
        graph.addVertex(source.getName());
        graph.addVertex(destination.getName());
        graph.setEdgeWeight(graph
            .addEdge(source.getName(), destination.getName()), time.getMinute());
    }

    public static List<String> getShortestPath(Station source, Station destination){
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(source.getName(), destination.getName()).getVertexList();
    }

    public static Time getShortestTime(Station source, Station destination){
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return Time.newTime((int)dijkstraShortestPath
            .getPathWeight(source.getName(), destination.getName()));
    }
}
