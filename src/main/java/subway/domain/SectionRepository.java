package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.view.OutputView;

import java.util.List;

public class SectionRepository {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private static final  WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static void addStation(Station station) {
        distanceGraph.addVertex(station);
        timeGraph.addVertex(station);
    }

    public static void addSectionInformation(String stationName
            , String nextStationName
            , SectionInformation sectionInformation) {
        Station station = StationRepository.findStationByName(stationName);
        Station nextStation = StationRepository.findStationByName(nextStationName);

        addDistanceEdgeWeight(station, nextStation, sectionInformation.getDistance());
        addTimeEdgeWeight(station, nextStation, sectionInformation.getTime());
    }

    private static void addDistanceEdgeWeight(Station station, Station nextStation, double distance) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(station, nextStation), distance);
    }

    private static void addTimeEdgeWeight(Station station, Station nextStation, double time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(station, nextStation), time);
    }

    public static List<Station> getSectionDistanceStations(Station departureStation, Station arrivalStation) {
        try {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);

            return dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        }
        catch (NullPointerException e) {
            OutputView.printSectionEmptyErrorMessage();

            return null;
        }
    }

    public static List<Station> getSectionTimeStations(Station departureStation, Station arrivalStation) {
        try {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);

            return dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        }
        catch (NullPointerException e) {
            OutputView.printSectionEmptyErrorMessage();

            return null;
        }

    }
}
