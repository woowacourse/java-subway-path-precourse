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
        validateDuplicate(source, destination);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        try {
            return dijkstraShortestPath.getPath(source.getName(), destination.getName())
                .getVertexList();
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("해당 역은 연결되어 있지 않습니다.");
        }
    }

    private static void validateDuplicate(Station source, Station destination) {
        if (source.equals(destination)){
            throw new IllegalArgumentException("출발역과 도착역이 동일합니다.");
        }
    }
}
