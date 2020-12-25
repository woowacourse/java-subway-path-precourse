package subway;

import subway.domain.Edge;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ApplicationInitializer {

    public static ApplicationContext injectDependencies() {
        Map<Station, Integer> stationMapper = new HashMap<>();
        initStation(stationMapper);
        ArrayList<Edge>[] subwayNetwork = new ArrayList[stationMapper.size() + 1];;
        initSubWayNetWork(subwayNetwork, stationMapper);
        DistanceController shortestDistance = new DistanceController(stationMapper, subwayNetwork);
        MinimumTime minimumTime = new MinimumTime(stationMapper, subwayNetwork);
        return new ApplicationContext(shortestDistance, minimumTime);
    }

    private static void initStation(Map<Station, Integer> stationMapper) {
        stationMapper.put(new Station("교대역"), 1);
        stationMapper.put(new Station("강남역"), 2);
        stationMapper.put(new Station("역삼역"), 3);
        stationMapper.put(new Station("남부터미널역"), 4);
        stationMapper.put(new Station("양재역"), 5);
        stationMapper.put(new Station("양재시민의숲역"), 6);
        stationMapper.put(new Station("매봉역"), 7);
    }

    private static void initSubWayNetWork(ArrayList<Edge>[] subwayNetwork,
                                        Map<Station, Integer> stationMapper) {
        for (int i=1; i<=stationMapper.size(); i++) {
            subwayNetwork[i] = new ArrayList<>();
        }
        subwayNetwork[stationMapper.get(new Station("교대역"))].add(
                new Edge(stationMapper.get(new Station("강남역")), 2, 3));
        subwayNetwork[stationMapper.get(new Station("강남역"))].add(
                new Edge(stationMapper.get(new Station("역삼역")), 2, 3));
        subwayNetwork[stationMapper.get(new Station("교대역"))].add(
                new Edge(stationMapper.get(new Station("남부터미널역")), 3, 2));
        subwayNetwork[stationMapper.get(new Station("남부터미널역"))].add(
                new Edge(stationMapper.get(new Station("양재역")), 6, 5));
        subwayNetwork[stationMapper.get(new Station("양재역"))].add(
                new Edge(stationMapper.get(new Station("매봉역")), 1, 1));
        subwayNetwork[stationMapper.get(new Station("강남역"))].add(
                new Edge(stationMapper.get(new Station("양재역")), 2, 8));
        subwayNetwork[stationMapper.get(new Station("양재역"))].add(
                new Edge(stationMapper.get(new Station("양재시민의숲역")), 10, 3));
        subwayNetwork[stationMapper.get(new Station("강남역"))].add(
                new Edge(stationMapper.get(new Station("교대역")), 2, 3));
        subwayNetwork[stationMapper.get(new Station("역삼역"))].add(
                new Edge(stationMapper.get(new Station("강남역")), 2, 3));
        subwayNetwork[stationMapper.get(new Station("남부터미널역"))].add(
                new Edge(stationMapper.get(new Station("교대역")), 3, 2));
        subwayNetwork[stationMapper.get(new Station("양재역"))].add(
                new Edge(stationMapper.get(new Station("남부터미널역")), 6, 5));
        subwayNetwork[stationMapper.get(new Station("매봉역"))].add(
                new Edge(stationMapper.get(new Station("양재역")), 1, 1));
        subwayNetwork[stationMapper.get(new Station("양재역"))].add(
                new Edge(stationMapper.get(new Station("강남역")), 2, 8));
        subwayNetwork[stationMapper.get(new Station("양재시민의숲역"))].add(
                new Edge(stationMapper.get(new Station("양재역")), 10, 3));
    }
}
