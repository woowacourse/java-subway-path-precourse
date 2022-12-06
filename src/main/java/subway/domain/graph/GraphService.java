package subway.domain.graph;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.util.MessageFactory;

import java.util.List;

import static subway.domain.util.ErrorCode.*;
import static subway.domain.util.InfoCode.LINE;
import static subway.domain.util.SetupConstant.*;

public class GraphService {
    private final MessageFactory messageFactory = new MessageFactory();

    private WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    void setUp() {
        List<String> stationNames = List.of(STATION_GYODAE, STATION_GANGNAM, STATION_YEOKSAM, STATION_NAMBU_TERMINAL, STATION_YANGJAE, STATION_YANGJAE_CITIZENS_FOREST, STATION_MAEBONG);
        for (String name : stationNames) {
            distanceGraph.addVertex(name);
            timeGraph.addVertex(name);
        }
        setUpDistances();
        setUpTimes();
    }

    String computeShortestDistanceResult(DijkstraShortestPath path, String station1, String station2) {
        List<String> stations = path.getPath(station1, station2).getVertexList();
        double totalPathWeight = path.getPathWeight(station1, station2);
        return buildShortestDistanceInfo(stations, totalPathWeight, 0);
    }

    private String buildShortestDistanceInfo(List<String> stationNames, double totalDistance, int totalTime) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messageFactory.makeInfoMessage(LINE));
        stringBuilder.append(messageFactory.makeDistanceInfo(String.valueOf(totalDistance)));
        stringBuilder.append(messageFactory.makeDistanceInfo(String.valueOf(totalTime)));
        for (String stationName : stationNames) {
            stringBuilder.append(messageFactory.makeInfo(stationName));
        }
        return stringBuilder.toString();
    }

    String findShortestDistancePath(String departStationName, String arriveStationName) {
        validatePresentStation(departStationName);
        validatePresentStation(arriveStationName);
        validateStationNames(departStationName, arriveStationName);

        DijkstraShortestPath shortestDistancePath = new DijkstraShortestPath(distanceGraph);
        validateShortestPath(shortestDistancePath);
        return computeShortestDistanceResult(shortestDistancePath, departStationName, arriveStationName);
    }

    private void validateShortestPath(DijkstraShortestPath path) {
        if (path == null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(STATION_NOT_CONNECTED));
        }
    }

    private void setUpDistances() {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_GYODAE, STATION_GANGNAM), DIST_GYODAE_TO_GANGNAM);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_GANGNAM, STATION_YEOKSAM), DIST_GANGNAM_TO_YEOKSAM);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_GYODAE, STATION_NAMBU_TERMINAL), DIST_GYODAE_TO_NAMBU_TERMINAL);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_NAMBU_TERMINAL, STATION_YANGJAE), DIST_NAMBU_TERMINAL_TO_YANGJAE);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_YANGJAE, STATION_MAEBONG), DIST_YANGJAE_TO_MAEBONG);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_GANGNAM, STATION_YANGJAE), DIST_GANGNAM_TO_YANGJAE);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_YANGJAE, STATION_YANGJAE_CITIZENS_FOREST), DIST_YANGJAE_TO_YANGJAE_CITIZEN_FOREST);
    }

    private void setUpTimes() {
        timeGraph.setEdgeWeight(timeGraph.addEdge(STATION_GYODAE, STATION_GANGNAM), TIME_GYODAE_TO_GANGNAM);
        timeGraph.setEdgeWeight(timeGraph.addEdge(STATION_GANGNAM, STATION_YEOKSAM), TIME_GANGNAM_TO_YEOKSAM);
        timeGraph.setEdgeWeight(timeGraph.addEdge(STATION_GYODAE, STATION_NAMBU_TERMINAL), TIME_GYODAE_TO_NAMBU_TERMINAL);
        timeGraph.setEdgeWeight(timeGraph.addEdge(STATION_NAMBU_TERMINAL, STATION_YANGJAE), TIME_NAMBU_TERMINAL_TO_YANGJAE);
        timeGraph.setEdgeWeight(timeGraph.addEdge(STATION_YANGJAE, STATION_MAEBONG), TIME_YANGJAE_TO_MAEBONG);
        timeGraph.setEdgeWeight(timeGraph.addEdge(STATION_GANGNAM, STATION_YANGJAE), TIME_GANGNAM_TO_YANGJAE);
        timeGraph.setEdgeWeight(timeGraph.addEdge(STATION_YANGJAE, STATION_YANGJAE_CITIZENS_FOREST), TIME_YANGJAE_TO_YANGJAE_CITIZEN_FOREST);
    }

    private void validateStationNames(String departStation, String arriveStation) {
        if (departStation == arriveStation) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(DUPLICATE_STATION_NAME));
        }
    }

    private void validatePresentStation(String stationName) {
        Station station = StationRepository.findByName(stationName);
        if (station == null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(STATION_NOT_FOUND));
        }
    }

}
