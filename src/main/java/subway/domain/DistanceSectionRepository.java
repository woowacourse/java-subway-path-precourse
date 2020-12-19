package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class DistanceSectionRepository {

    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    static {
        SectionRepository.sections().stream().forEach(section -> {
            graph.addVertex(section.getSource().getName());
            graph.addVertex(section.getDestination().getName());
            graph.setEdgeWeight(graph.addEdge(
                section.getSource().getName(),
                section.getDestination().getName()),
                section.getDistance().getKilometer());
        });
    }

    public static List<String> getShortestPath(Station source, Station destination) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(source.getName(), destination.getName())
            .getVertexList();
    }

//    public static Distance getShortestDistance(Station source, Station destination){
//        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
//        return Distance.newDistance((int)dijkstraShortestPath
//            .getPathWeight(source.getName(), destination.getName()));
//    }
}
