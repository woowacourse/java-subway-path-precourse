package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

import subway.view.OutputView;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    public static void addAll(List<Section> newSections) {
        sections.addAll(newSections);
    }

    public static void getShortestDistancePath(String startStationName, String endStationName) {

        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);
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

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(
            graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStationName, endStationName)
            .getVertexList();
        OutputView.printResult(shortestPath);
    }

    public static void getShortestTimePath(String startStationName, String endStationName) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

        for (Section section : sections) {
            graph.addVertex(section.getStationName());
        }

        for (Section section : sections) {
            if (section.getNextStation() != null) {
                graph.setEdgeWeight(
                    graph.addEdge(section.getStationName(), section.getNextStationName()),
                    section.getTime());
            }
        }

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(
            graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStationName, endStationName)
            .getVertexList();
        OutputView.printResult(shortestPath);
    }


}
