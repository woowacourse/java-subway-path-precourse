package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayDurationGraph {
    private static final WeightedMultigraph<Station, Section> durationGraph = new WeightedMultigraph<>(Section.class);

    static {
        SectionRepository.getAllSections().stream().forEach(section -> {
            durationGraph.addVertex(section.getDepartureStation());
            durationGraph.addVertex(section.getArrivalStation());
            durationGraph.addEdge(section.getDepartureStation(), section.getArrivalStation(), section);
            durationGraph.setEdgeWeight(section, section.getDuration());
        });
    }

    public static List<Section> getMinimumSections(Station departue, Station arrival) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(durationGraph);
        return dijkstraShortestPath.getPath(departue, arrival).getEdgeList();
    }
}