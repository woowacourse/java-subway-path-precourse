package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import subway.controller.Init;

public class StationGraph {
    private static List<List<Section>> stationDistanceGraph;
    private static PriorityQueue<Section> pq = new PriorityQueue<>((p1, p2) -> p1.getDistance() - p2.getDistance());
    private static int[] dist = new int[Init.initList.size() + 1];
    private static int[] time = new int[Init.initList.size() + 1];
    private static boolean[] check = new boolean[Init.initList.size() + 1];

    public StationGraph() {
        stationDistanceGraph = new ArrayList<>();
    }

    public List<List<Section>> getStationDistanceGraph() {
        return stationDistanceGraph;
    }

    public static List<Integer> dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(check, false);
        pq.offer(new Section(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            detailDijkstra();
        }
        return Arrays.asList(dist[end], time[end]);
    }

    private static void detailDijkstra() {
        Section curNode = pq.poll();
        int cur = curNode.getEndStation();

        if (!check[cur]) {
            check[cur] = true;
            comparisonAndRoop(cur);
        }
    }

    private static void comparisonAndRoop(int cur) {
        for (Section node : stationDistanceGraph.get(cur)) {
            if (!check[node.getEndStation()] && dist[node.getEndStation()] > dist[cur] + node.getDistance()) {
                dist[node.getEndStation()] = dist[cur] + node.getDistance();
                time[node.getEndStation()] = time[cur] + node.getTime();
                pq.add(new Section(node.getEndStation(), dist[node.getEndStation()]));
            }
        }
    }

    public static List<Integer> dijkstraTime(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(time, Integer.MAX_VALUE);
        Arrays.fill(check, false);
        pq.offer(new Section(start, 0));
        dist[start] = 0;
        time[start] = 0;

        while (!pq.isEmpty()) {
            detailDijkstraTime();
        }
        return Arrays.asList(dist[end], time[end]);
    }

    private static void detailDijkstraTime() {
        Section curNode = pq.poll();
        int cur = curNode.getEndStation();

        if (!check[cur]) {
            check[cur] = true;
            comparisonAndRoopTime(cur);
        }
    }

    private static void comparisonAndRoopTime(int cur) {
        for (Section node : stationDistanceGraph.get(cur)) {
            if (!check[node.getEndStation()] && time[node.getEndStation()] > time[cur] + node.getTime()) {
                dist[node.getEndStation()] = dist[cur] + node.getDistance();
                time[node.getEndStation()] = time[cur] + node.getTime();
                pq.add(new Section(node.getEndStation(), dist[node.getEndStation()]));
            }
        }
    }
}
