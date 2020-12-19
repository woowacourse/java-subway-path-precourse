package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class SectionRepository {

    static WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    static List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return sections;
    }

    public static void addSection(Section section) {
        sections.add(section);
        addVertex(section.getDeparture(), section.getArrival());
        addWeight(section.getDeparture(), section.getArrival(), section.getCostTime());
    }

    private static void addWeight(Station departure, Station arrival, int costTime) {
        if (!graph.containsEdge(graph.addEdge(departure.getName(), arrival.getName()))) {
            graph.setEdgeWeight(graph.addEdge(departure.getName(), arrival.getName()), costTime);
        }
    }

    private static void addVertex(Station departure, Station arrival) {
        if (!graph.containsVertex(departure.getName())) {
            graph.addVertex(departure.getName());
        }
        if (!graph.containsVertex(arrival.getName())) {
            graph.addVertex(arrival.getName());
        }
    }

    public static int findShortestPath(String departure, String destination) {

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(departure, destination).getVertexList();

        return (int) sections.stream()
                .filter(section -> section.hasStation(departure, destination))
                .mapToInt(Section::getDistance)
                .sum();

    }

}
