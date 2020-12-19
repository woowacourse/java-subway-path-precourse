package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class TimeSectionRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    static {
        SectionRepository.sections().stream().forEach(section -> {
            graph.addVertex(section.getSource().getName());
            graph.addVertex(section.getDestination().getName());
            graph.setEdgeWeight(graph.addEdge(
                section.getSource().getName(),
                section.getDestination().getName()),
                section.getTime().getMinute());
        });
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
