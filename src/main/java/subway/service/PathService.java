package subway.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import subway.InitialData;
import subway.domain.Path;
import subway.domain.PathRepository;
import subway.domain.Station;
import subway.utils.Result;
import subway.view.OutputView;

public class PathService {
    private static final int INFINITY = Integer.MAX_VALUE;
    private static final String SAME_STATION_ERROR = "[ERROR] 출발역과 도착역이 동일합니다.\n";

    public static void register(String departureStationName, String arrivalStationName,
        int distance, int time) {
        Station departureStation = StationService.searchOneByName(departureStationName);
        Station arrivalStation = StationService.searchOneByName(arrivalStationName);
        Path upStreamPath = new Path(departureStation,arrivalStation,distance,time);
        Path downStreamPath = new Path(arrivalStation,departureStation,distance,time);
        PathRepository.addPath(upStreamPath);
        PathRepository.addPath(downStreamPath);
    }

    public static void searchShortestDistance(String departureStationName, String arrivalStationName) {
        Station departureStation = StationService.searchOneByName(departureStationName);
        Station arrivalStation = StationService.searchOneByName(arrivalStationName);
        validateSameStations(departureStation, arrivalStation);
        Map<Station, Map<Station, Integer>> distanceMap = PathRepository
            .convertPathsToDistanceMap();
        List<Station> stops = new ArrayList<>();
        Result result = dijkstra(distanceMap, departureStation);
        getStopStations(arrivalStation, result, stops);
        Collections.reverse(stops);
        OutputView.printList(result,arrivalStation,stops, result.distances.get(arrivalStation));
    }

    private static void getStopStations(Station arrivalStation, Result result, List<Station> stops) {
        Station curNode = arrivalStation;
        stops.add(arrivalStation);
        while(!result.preNode.get(curNode).equals(new Station(""))){
            curNode = result.preNode.get(curNode);
            stops.add(curNode);
        }
    }

    private static void validateSameStations(Station departureStation, Station arrivalStation) {
        if(departureStation.equals(arrivalStation)){
            throw new IllegalArgumentException(SAME_STATION_ERROR);
        }
    }

    private static Result dijkstra(Map<Station, Map<Station, Integer>> graph, Station source){
        Map<Station, Integer> distances = new HashMap<>();
        Map<Station, Station> preNode = new HashMap<>();
        Result result = new Result();
        distances.put(source, 0);
        preNode.put(source, new Station(""));
        Set<Station> Q = new HashSet<>();
        convertMapKeyToSet(graph, source, distances, preNode, Q);
        iterateUntilQEmpty(graph, distances, preNode, Q);
        result.distances.putAll(distances);
        result.preNode.putAll(preNode);
        return result;
    }

    private static void iterateUntilQEmpty(Map<Station, Map<Station, Integer>> graph,
        Map<Station, Integer> distances, Map<Station, Station> preNode, Set<Station> Q) {
        while(!Q.isEmpty()){
            Station minNode = new Station("");
            int minNodeDistance = INFINITY;
            for(Station node: Q){
                if(distances.get(node) < minNodeDistance){
                    minNode = node;
                    minNodeDistance = distances.get(node);
                }
            }
            Q.remove(minNode);

            Map<Station, Integer> minNodeMap = graph.get(minNode);
            for(Station key: minNodeMap.keySet()){
                int distance = minNodeDistance + minNodeMap.get(key);
                if(distance < distances.get(key)){
                    distances.put(key, distance);
                    preNode.put(key, minNode);
                }
            }
        }
    }

    private static void convertMapKeyToSet(Map<Station, Map<Station, Integer>> graph, Station source,
        Map<Station, Integer> distances, Map<Station, Station> preNode, Set<Station> Q) {
        for(Station key: graph.keySet()){
            Q.add(key);
            if(!key.equals(source)){
                distances.put(key, INFINITY);
                preNode.put(key, new Station(""));
            }
        }
    }
}
