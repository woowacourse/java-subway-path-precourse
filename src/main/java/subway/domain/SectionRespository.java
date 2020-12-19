package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class SectionRespository {

    private static final List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static void addAll(List<Section> newSections) {
        sections.addAll(newSections);
    }

    public void getShortestDistancePath(String startStationName, String endStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        for (Section section : sections) {
            graph.addVertex(section.getStationName());
        }

        for (Section section : sections) {
            if (section.getNextStation() != null) {
                graph.setEdgeWeight(
                    graph.addEdge(section.getStationName(), section.getNextStationName()),
                    section.getDistance());
            }
        }

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStationName, endStationName)
            .getVertexList();
    }
}
