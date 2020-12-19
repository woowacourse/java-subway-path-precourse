package subway.utils;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.SectionRepository;

public class GetPath {

    private static void addStationName(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        List<Section> sections = SectionRepository.sections();
        for (Section section : sections) {
            graph.addVertex(section.getUpStation().getName());
            graph.addVertex(section.getDownStation().getName());
        }
    }

    private static void addWeight(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        List<Section> sections = SectionRepository.sections();
        for (Section section : sections) {
            graph.setEdgeWeight(
                graph.addEdge(section.getUpStation().getName(), section.getDownStation().getName()),
                section.getDistance());
        }
    }

    public static List<String> getShortestDistance(String upStationName,
        String downStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        addStationName(graph);
        addWeight(graph);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List shortestPath = dijkstraShortestPath
            .getPath(upStationName, downStationName).getVertexList();
        return shortestPath;
    }

    public static int getShortestDistanceWeight(String upStationName,
        String downStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        addStationName(graph);
        addWeight(graph);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        double shortestWeight = dijkstraShortestPath
            .getPath(upStationName, downStationName).getWeight();
        return (int) shortestWeight;
    }

    public static List<String> getShortestTime(String upStationName,
        String downStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        addStationName(graph);
        addWeight(graph);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List shortestPath = dijkstraShortestPath
            .getPath(upStationName, downStationName).getVertexList();
        return shortestPath;
    }

    public static int getShortestTimeWeight(String upStationName,
        String downStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(
            DefaultWeightedEdge.class);
        addStationName(graph);
        addWeight(graph);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        double shortestWeight = dijkstraShortestPath
            .getPath(upStationName, downStationName).getWeight();
        return (int) shortestWeight;
    }

}
