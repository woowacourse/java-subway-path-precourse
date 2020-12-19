package subway.utils;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.SectionRepository;

public class GetPath {

    public static List<String> getDijkstraShortestPath(String upStationName, String downStationName) {
        List<Section> sections = SectionRepository.sections();
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);

        for (Section section : sections) {
            graph.addVertex(section.getUpStation().getName());
            graph.addVertex(section.getDownStation().getName());
        }
        for (Section section : sections) {
            graph.setEdgeWeight(
                graph.addEdge(section.getUpStation().getName(), section.getDownStation().getName()),
                section.getDistance());
        }
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
            List shortestPath = dijkstraShortestPath
                .getPath(upStationName, downStationName).getVertexList();
            return shortestPath;
    }
}
