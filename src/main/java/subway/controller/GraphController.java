package subway.controller;

import subway.domain.*;

import java.util.List;

public class GraphController {

    public GraphDTO getGraphInfo(String startStationName, String endStationName, GraphType graphType) {
        List<Station> path = getPath(startStationName, endStationName, graphType);
        int time = 0;
        int distance = 0;

        if (graphType.equals(GraphType.TIME)) {
            time = getWeight(startStationName, endStationName, graphType);
            distance = getPathWeight(path, GraphType.DISTANCE);
        } else if (graphType.equals(GraphType.DISTANCE)) {
            distance = getWeight(startStationName, endStationName, graphType);
            time = getPathWeight(path, GraphType.TIME);
        }

        return new GraphDTO(distance, time, path);
    }

    private int getPathWeight(List<Station> path, GraphType graphType) {
        int weight = 0;
        Graph graph = GraphRepository.findGraphByType(graphType);
        for (int i = 1; i < path.size(); i++) {
            Station before = path.get(i - 1);
            Station after = path.get(i);
            weight += graph.getEdgeWeight(before, after);
        }
        return weight;
    }

    private List<Station> getPath(String startStationName, String endStationName, GraphType graphType) {
        Station startStation = StationRepository.findStationByName(startStationName);
        Station endStation = StationRepository.findStationByName(endStationName);
        return GraphRepository.findGraphByType(graphType).shortestPath(startStation, endStation);
    }

    private int getWeight(String startStationName, String endStationName, GraphType graphType) {
        Station startStation = StationRepository.findStationByName(startStationName);
        Station endStation = StationRepository.findStationByName(endStationName);
        return (int) GraphRepository.findGraphByType(graphType).shortestPathWeight(startStation, endStation);
    }

}
