package subway;

import subway.domain.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ApplicationInitializer {

    public static class Edge {
        private int endStation;
        private int distance;
        private int time;
        //        Set<Line> includedLine = new HashSet<>();
        public Edge(int endStation, int distance, int time) {
            if (distance <= 0) { throw new IllegalArgumentException("[ERROR] 거리는 양의 정수입니다.");}
            if (time <= 0) { throw new IllegalArgumentException("[ERROR] 시간은 양의 정수입니다.");}
            this.endStation = endStation;
            this.distance = distance;
            this.time = time;
        }
    }

    public static ApplicationContext injectDependencies() {
        Map<Station, Integer> stationMapper = new HashMap<>();
        initStation(stationMapper);
        ArrayList<Edge>[] subwayNetwork = new ArrayList[stationMapper.size() + 1];;
        initSubWayNetWork(subwayNetwork, stationMapper);
        ShortestDistance shortestDistance = new ShortestDistance(stationMapper, subwayNetwork);
        MinimumTime minimumTime = new MinimumTime(stationMapper, subwayNetwork);
        return new ApplicationContext(shortestDistance, minimumTime);
    }

    // 구현
//    public ApplicationInitializer() {
//        initStation();
//        initSubWayNetWork();
//    }

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
        subwayNetwork[stationMapper.get(new Station("양재역"))].add(
                new Edge(stationMapper.get(new Station("매봉역")), 1, 1));
    }
}
