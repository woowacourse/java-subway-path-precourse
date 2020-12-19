package subway.domain.searcher;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.section.Section;
import subway.domain.station.Station;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;

public class DistancePathSearcher {

    private final SectionRepository sectionRepository = new SectionRepository();
    private final StationRepository stationRepository = new StationRepository();

    private WeightedMultigraph<Station, Double> graph = new WeightedMultigraph(
        DefaultWeightedEdge.class);

    public List<Station> getTotalRoute(Station from, Station to) {

        addAllStationData();
        addAllSectionData();

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);

        return dijkstraShortestPath.getPath(from, to).getVertexList();
    }

    private void addAllSectionData() {
        List<Section> sections = sectionRepository.findAll();
        for (Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getNextStation(), section.getPreStation()),
                section.getDistance());
        }
    }

    private void addAllStationData() {
        List<Station> stations = stationRepository.stations();
        for (Station station : stations) {
            graph.addVertex(station);
        }
    }


}
