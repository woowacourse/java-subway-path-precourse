package subway.domain.section.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.section.model.Section;
import subway.domain.section.model.SectionRepository;
import subway.station.model.Station;

import java.util.List;

public class SectionService {

    public static List<Station> findDistanceShortestPath(Station startStation, Station arrivalStation) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        List<Section> sections = SectionRepository.sections();
        sections.stream()
                .forEach(section -> section.updateDistanceGraph(graph));

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, arrivalStation).getVertexList();
    }
}
