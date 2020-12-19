package subway.repository;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.util.ShortestDistance;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class SectionRepository {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph =
            new WeightedMultigraph(DefaultWeightedEdge.class);

    private static final List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static List<String> CalculateShortestDistance(String startStation, String finishStation) {
        addVertex();
        sections.forEach(section -> addEdgeWeight(section.getStationName(),
                section.getNextStationName(),
                section.getStreet()));
        return ShortestDistance.getStations(startStation, finishStation);
    }

    private static void addVertex() {
        ShortestDistance.addVertex(StationRepository.stations());
    }

    private static void addEdgeWeight(String stationName, String nextStationName, int wight) {
        ShortestDistance.setEdgeWeight(stationName, nextStationName, wight);
    }

    public static List<String> CalculateMinimumTime(String startStation, String finishStation) {
        addVertex();
        sections.forEach(section -> addEdgeWeight(section.getStationName(),
            section.getNextStationName(),
            section.getTime()));
        return ShortestDistance.getStations(startStation, finishStation);
    }
}
