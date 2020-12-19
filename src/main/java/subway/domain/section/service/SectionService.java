package subway.domain.section.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.section.model.Section;
import subway.domain.section.model.SectionRepository;
import subway.station.model.Station;

import java.util.List;

public class SectionService {
    private static final String START_STATION_IS_EQUAL_TO_ARRIVAL_STATION_MESSAGE = "[ERROR] 출발역과 도착역이 동일합니다.";
    private static final int ZERO = 0;

    public static List<Station> findDistanceShortestPath(Station startStation, Station arrivalStation) {
        validateFindShortestPath(startStation, arrivalStation);
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        List<Section> sections = SectionRepository.sections();
        sections.stream()
                .forEach(section -> section.updateDistanceGraph(graph));

        return findShortestPath(startStation, arrivalStation, graph);
    }

    public static List<Station> findRunTimeShortestPath(Station startStation, Station arrivalStation) {
        validateFindShortestPath(startStation, arrivalStation);
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        List<Section> sections = SectionRepository.sections();
        sections.stream()
                .forEach(section -> section.updateRunTimeGraph(graph));

        return findShortestPath(startStation, arrivalStation, graph);
    }

    private static void validateFindShortestPath(Station startStation, Station arrivalStation) {
        if (startStation.equals(arrivalStation)) {
            throw new IllegalArgumentException(START_STATION_IS_EQUAL_TO_ARRIVAL_STATION_MESSAGE);
        }
    }

    private static List findShortestPath(Station startStation, Station arrivalStation,
                                         WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, arrivalStation).getVertexList();
    }

    public static int findTotalDistance(List<Station> path) {
        List<Section> sections = SectionRepository.sections();

        int pathSize = path.size();
        int distance = 0;
        for (int i = 0; i < pathSize - 1; i++) {
            distance += getDistance(path.get(i), path.get(i + 1), sections);
        }

        return distance;
    }

    private static int getDistance(Station startStation, Station arrivalStation, List<Section> sections) {
        for (Section section : sections) {
            if (section.isEqualTo(startStation, arrivalStation)) {
                return section.getDistance();
            }
        }

        return ZERO;
    }


    public static int findTotalRunTime(List<Station> path) {
        List<Section> sections = SectionRepository.sections();

        int pathSize = path.size();
        int runTime = 0;
        for (int i = 0; i < pathSize - 1; i++) {
            runTime += getRunTime(path.get(i), path.get(i + 1), sections);
        }

        return runTime;
    }

    private static int getRunTime(Station startStation, Station arrivalStation, List<Section> sections) {
        for (Section section : sections) {
            if (section.isEqualTo(startStation, arrivalStation)) {
                return section.getRunTime();
            }
        }

        return ZERO;
    }
}
