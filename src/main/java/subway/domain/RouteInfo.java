package subway.domain;

import static subway.domain.StationInfo.GANGNAM_STATION;
import static subway.domain.StationInfo.GYOBYEON_STATION;
import static subway.domain.StationInfo.MAEBONG_STATIO;
import static subway.domain.StationInfo.NAMBU_TERMINAL_STATION;
import static subway.domain.StationInfo.YANGJAE_CITIZEN_FOREST_STATION;
import static subway.domain.StationInfo.YANGJAE_STATION;
import static subway.domain.StationInfo.YEOKSAM_STATION;
import static subway.exception.ErrorInputException.ErrorMessage.IS_NOT_REGISTERED;

import java.util.Arrays;
import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.exception.ErrorInputException;
import subway.repository.StationRepository;

public enum RouteInfo {
    LINE_2_GYOBYEON_GANGNAM("2", GYOBYEON_STATION, GANGNAM_STATION, 2, 3),
    LINE_2_GANGNAM_YEOKSAM("2", GANGNAM_STATION, YEOKSAM_STATION, 2, 3),
    LINE_3_GYOBYEON_NAMBU_TERMINAL("2", GYOBYEON_STATION, NAMBU_TERMINAL_STATION, 3, 2),
    LINE_3_NAMBU_TERMINAL_YANGJAE("3", NAMBU_TERMINAL_STATION, YANGJAE_STATION, 6, 5),
    LINE_3_YANGJAE_MAEBONG("3", YANGJAE_STATION, MAEBONG_STATIO, 1, 1),
    NEW_BUNDANG_GANGNAM_YANGJAE("NewBunDang", GANGNAM_STATION, YANGJAE_STATION, 2, 8),
    NEW_BUNDANG_YANGJAE_YANGJAE_CITIZEN_FOREST("NewBunDang", YANGJAE_STATION, YANGJAE_CITIZEN_FOREST_STATION, 10, 3);

    private final String line;
    private final StationInfo startStation;
    private final StationInfo endStation;
    private final int distance;
    private final int time;

    RouteInfo(String line, StationInfo startStation, StationInfo endStation, int distance, int time) {
        this.line = line;
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
        this.time = time;
    }

    public void calculateShortestPath(WeightedMultigraph<String, DefaultWeightedEdge> graph, RouteInfo routeInfo) {
        addEdgeWithWeight(graph, routeInfo, routeInfo.distance);
    }

    public void calculateMinimumTime(WeightedMultigraph<String, DefaultWeightedEdge> graph, RouteInfo routeInfo) {
        addEdgeWithWeight(graph, routeInfo, routeInfo.time);
    }

    private void addEdgeWithWeight(WeightedMultigraph<String, DefaultWeightedEdge> graph, RouteInfo routeInfo,
                                   int weight) {
        Station startStation = StationRepository.getStation(routeInfo.startStation.getName());
        Station endStation = StationRepository.getStation(routeInfo.endStation.getName());
        graph.addVertex(startStation.getName());
        graph.addVertex(endStation.getName());
        graph.setEdgeWeight(graph.addEdge(startStation.getName(), endStation.getName()), weight);
    }

    public static int calculateTotalDistance(WeightedMultigraph<String, DefaultWeightedEdge> graph,
                                             List<DefaultWeightedEdge> edges) {
        return edges.stream()
                .map(edge -> getRouteInfo(graph, edge))
                .mapToInt(routeInfo -> routeInfo.distance)
                .sum();
    }

    public static int calculateTotalTime(WeightedMultigraph<String, DefaultWeightedEdge> graph,
                                         List<DefaultWeightedEdge> edges) {
        return edges.stream()
                .map(edge -> getRouteInfo(graph, edge))
                .mapToInt(routeInfo -> routeInfo.time)
                .sum();
    }

    private static RouteInfo getRouteInfo(WeightedMultigraph<String, DefaultWeightedEdge> graph,
                                          DefaultWeightedEdge edge) {
        String startStationName = graph.getEdgeSource(edge);
        String endStationName = graph.getEdgeTarget(edge);
        RouteInfo routeInfo = RouteInfo.findRouteInfo(startStationName, endStationName);
        return routeInfo;
    }

    public static RouteInfo findRouteInfo(String startStation, String endStation) {
        while (true) {
            try {
                return Arrays.stream(RouteInfo.values())
                        .filter(routeInfo -> routeInfo.startStation.getName().equals(startStation)
                                && routeInfo.endStation.getName().equals(endStation))
                        .findFirst()
                        .orElseThrow(() -> new ErrorInputException(IS_NOT_REGISTERED));
            } catch (ErrorInputException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

