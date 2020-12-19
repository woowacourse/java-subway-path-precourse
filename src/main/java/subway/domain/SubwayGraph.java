package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.exception.NotLinkedStationsException;

import java.util.List;

public class SubwayGraph {
    private static final WeightedMultigraph<Station, Section> distanceGraph = new WeightedMultigraph<>(Section.class);
    private static final WeightedMultigraph<Station, Section> durationGraph = new WeightedMultigraph<>(Section.class);

    static {
        SectionRepository.getAllSections().forEach(section -> {
            addDistanceGraph(section);
            addDurationGraph(section);
        });
    }

    private static void addDistanceGraph(Section section) {
        distanceGraph.addVertex(section.getDepartureStation());
        distanceGraph.addVertex(section.getArrivalStation());
        distanceGraph.addEdge(section.getDepartureStation(), section.getArrivalStation(), section);
        distanceGraph.setEdgeWeight(section, section.getDistance());
    }

    private static void addDurationGraph(Section section) {
        durationGraph.addVertex(section.getDepartureStation());
        durationGraph.addVertex(section.getArrivalStation());
        durationGraph.addEdge(section.getDepartureStation(), section.getArrivalStation(), section);
        durationGraph.setEdgeWeight(section, section.getDuration());
    }

    public static Sections getMinimumSections(boolean isDistance, Station departue, Station arrival) {
        DijkstraShortestPath<Station, Section> dijkstraShortestPath = null;

        if (isDistance) {
            dijkstraShortestPath = new DijkstraShortestPath<>(distanceGraph);
        } else {
            dijkstraShortestPath = new DijkstraShortestPath<>(durationGraph);
        }

        List<Section> shortestList = dijkstraShortestPath.getPath(departue, arrival).getEdgeList();

        if (shortestList.size() == 0) {
            throw new NotLinkedStationsException();
        }

        return new Sections(shortestList);
    }
}