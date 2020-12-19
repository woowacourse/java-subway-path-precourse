package subway.repository;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.util.GraphCalculator;

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
        return GraphCalculator.getStations(startStation, finishStation);
    }

    private static void addVertex() {
        GraphCalculator.addVertex(StationRepository.stations());
    }

    private static void addEdgeWeight(String stationName, String nextStationName, int wight) {
        GraphCalculator.setEdgeWeight(stationName, nextStationName, wight);
    }

    public static List<String> CalculateMinimumTime(String startStation, String finishStation) {
        addVertex();
        sections.forEach(section -> addEdgeWeight(section.getStationName(),
            section.getNextStationName(),
            section.getTime()));
        return GraphCalculator.getStations(startStation, finishStation);
    }

    public static String findTotalDistance(List<String> shortestDistanceStations) {
        int totalDistance = 0;
        //todo: 최소 거리 구현
//        for (int i = 1; i < shortestDistanceStations.size(); i++) {
//            String stationName = shortestDistanceStations.get(i - 1);
//            String nextStationName = shortestDistanceStations.get(i);
//
//            Section section = findByStationName(stationName);
//
//            if (section.equalsStartName(stationName)
//                    && section.equalsNextStationName(nextStationName)) {
//                totalDistance += section.getStreet();
//            }
//        }
        return String.valueOf(totalDistance);
    }

    private static Section findByStationName(String stationName) {
        for (Section section : sections) {
            if (section.equalsStartName(stationName)) {
                return section;
            }
        }
        //todo: 없을 경우 예외 처리
        return null;
    }

}
