package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class SubwayDistanceGraph {
    private static final WeightedMultigraph<Station, Section> distanceGraph = new WeightedMultigraph<>(Section.class);

    static {
        SectionRepository.getAllSections().stream().forEach(section -> {
            distanceGraph.addVertex(section.getDepartureStation());
            distanceGraph.addVertex(section.getArrivalStation());
            distanceGraph.addEdge(section.getDepartureStation(), section.getArrivalStation(), section);
            distanceGraph.setEdgeWeight(section, section.getDistance());
        });
    }

    public static List<Section> getMinimumSections(Station departue, Station arrival) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        return dijkstraShortestPath.getPath(departue, arrival).getEdgeList();
    }
}