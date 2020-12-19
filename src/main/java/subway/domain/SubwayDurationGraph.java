package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;

public class SubwayDurationGraph {
    private static final WeightedMultigraph<Station, Section> durationGraph = new WeightedMultigraph<>(Section.class);

    static {
        SectionRepository.getAllSections().forEach(section -> {
            durationGraph.addVertex(section.getDepartureStation());
            durationGraph.addVertex(section.getArrivalStation());
            durationGraph.addEdge(section.getDepartureStation(), section.getArrivalStation(), section);
            durationGraph.setEdgeWeight(section, section.getDuration());
        });
    }

    public static Sections getMinimumSections(Station departue, Station arrival) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(durationGraph);
        return new Sections(dijkstraShortestPath.getPath(departue, arrival).getEdgeList());
    }
}