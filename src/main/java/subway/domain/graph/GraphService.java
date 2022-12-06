package subway.domain.graph;

import org.jgrapht.GraphPath;
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

    private final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    void setUp() {
        setUpStationsToDistanceGraph();
        setUpStationsToTimeGraph();
        setUpDistances();
        setUpTimes();
    }

    String computeShortestDistanceResult(GraphPath<Station, DefaultWeightedEdge> path) {
        List<Station> stations = path.getVertexList();
        int totalPathWeight = (int) path.getWeight();
        return buildShortestDistanceInfo(stations, totalPathWeight, 0);
    }

    private String buildShortestDistanceInfo(List<Station> stations, int totalDistance, int totalTime) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messageFactory.makeInfoMessage(LINE));
        stringBuilder.append(messageFactory.makeDistanceInfo(String.valueOf(totalDistance)));
        stringBuilder.append(messageFactory.makeDistanceInfo(String.valueOf(totalTime)));
        for (Station station : stations) {
            stringBuilder.append(messageFactory.makeInfo(station.getName()));
        }
        return stringBuilder.toString();
    }

    String findShortestDistancePath(String departStationName, String arriveStationName) {
        Station departStation = findPresentStation(departStationName);
        Station arriveStation = findPresentStation(arriveStationName);
        validateStationNames(departStation, arriveStation);

        DijkstraShortestPath shortestDistancePath = new DijkstraShortestPath(distanceGraph);
        GraphPath<Station, DefaultWeightedEdge> path = shortestDistancePath.getPath(departStation, arriveStation);
        validateShortestPath(path);
        return computeShortestDistanceResult(path);
    }

    private void validateShortestPath(GraphPath<Station, DefaultWeightedEdge> path) {
        if (path == null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(STATION_NOT_CONNECTED));
        }
    }

    private void setUpStationsToDistanceGraph() {
        distanceGraph.addVertex(STATION_GYODAE);
        distanceGraph.addVertex(STATION_GANGNAM);
        distanceGraph.addVertex(STATION_YEOKSAM);
        distanceGraph.addVertex(STATION_NAMBU_TERMINAL);
        distanceGraph.addVertex(STATION_YANGJAE);
        distanceGraph.addVertex(STATION_YANGJAE_CITIZENS_FOREST);
        distanceGraph.addVertex(STATION_MAEBONG);
    }

    private void setUpStationsToTimeGraph() {
        timeGraph.addVertex(STATION_GYODAE);
        timeGraph.addVertex(STATION_GANGNAM);
        timeGraph.addVertex(STATION_YEOKSAM);
        timeGraph.addVertex(STATION_NAMBU_TERMINAL);
        timeGraph.addVertex(STATION_YANGJAE);
        timeGraph.addVertex(STATION_YANGJAE_CITIZENS_FOREST);
        timeGraph.addVertex(STATION_MAEBONG);
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

    private void validateStationNames(Station departStation, Station arriveStation) {
        if (departStation == arriveStation) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(DUPLICATE_STATION_NAME));
        }
    }

    private Station findPresentStation(String stationName) {
        Station station = StationRepository.findByName(stationName);
        if (station == null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(STATION_NOT_FOUND));
        }
        return station;
    }

}
