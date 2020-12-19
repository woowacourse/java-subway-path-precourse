package subway;

import subway.domain.NodeData;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class FindPath {

    private static final int INIT_MIN_VALUE = 0;
    private static final int MAX_VALUE = 99999999;

    private static ArrayList<ArrayList<Pair>> subwayList;
    private static int dist[];
    private static boolean visited[];
    private static int parent[];
    private static int stationSize;
    private static PriorityQueue<Pair> q;

    public static void start(String select, String startStation, String arriveStation) {
        setBeforeDijkstra(select, startStation);
        int minCost = startDijkstra(startStation, arriveStation);
        if (minCost == MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] 서로 연결되어 있지 않은 역입니다.");
        }
        String kind = Constants.DISTANCE_COST;
        if (select.equals(Constants.FUNCTION_TWO)) {
            kind = Constants.TIME_COST;
        }
        int anotherMinCost = traceMinCost(findNumberByName(startStation), findNumberByName(arriveStation), select);
        Stack<String> stack = tracePath(findNumberByName(startStation), findNumberByName(arriveStation));
        PrintScreen.printMinPathStationToArrive(kind, stack, minCost, anotherMinCost);
    }

    private static int traceMinCost(int startNumber, int endNumber, String kind) {
        if (kind.equals(Constants.FUNCTION_ONE)) {
            kind = Constants.TIME_COST;
        }
        if (kind.equals(Constants.FUNCTION_TWO)) {
            kind = Constants.DISTANCE_COST;
        }
        int minCost = 0;
        int cur = endNumber;

        while (cur != startNumber) {
            minCost += StationRepository.getCost(findNameByNumber(cur), findNameByNumber(parent[cur]), kind);
            cur = parent[cur];
        }
        return minCost;
    }

    private static Stack<String> tracePath(int startNumber, int endNumber) {
        Stack<String> stack = new Stack<>();
        int cur = endNumber;

        while (cur != startNumber) {
            stack.push(findNameByNumber(cur));
            cur = parent[cur];
        }
        stack.push(findNameByNumber(cur));
        return stack;
    }

    //depth 2이하로 고치기, 메소드 15줄 이하
    private static int startDijkstra(String startStation, String arriveStation) {
        int startNumber = findNumberByName(startStation);
        int arriveNumber = findNumberByName(arriveStation);
        dist[startNumber] = INIT_MIN_VALUE;
        visited[startNumber] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            int start = p.start;

            for (int i = 0; i < subwayList.get(start).size(); i++) {
                int end = subwayList.get(start).get(i).end;
                int cost = subwayList.get(start).get(i).cost;
                if (!visited[end]) {
                    if (dist[end] > dist[start] + cost) {
                        dist[end] = dist[start] + cost;
                        q.add(new Pair(end, 0, dist[end]));
                        parent[end] = start;
                    }
                }
            }
            visited[start] = true;
        }

        return dist[arriveNumber];
    }

    private static void setBeforeDijkstra(String select, String startStation) {
        subwayList = new ArrayList<ArrayList<Pair>>();
        stationSize = StationRepository.getSize();
        setSubwayList(select);
        dist = new int[stationSize];
        visited = new boolean[stationSize];
        parent = new int[stationSize];
        Arrays.fill(dist, MAX_VALUE);
        q = new PriorityQueue<>();

        q.add(new Pair(findNumberByName(startStation), 0, 0));
    }

    private static void setSubwayList(String select) {
        for (int i = 0; i < stationSize; i++) {
            subwayList.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < stationSize; i++) {
            Station station = StationRepository.stations().get(i);
            for (NodeData nodeData : station.getNodeData()) {
                int cost = selectDistanceOrTime(select, nodeData);
                subwayList.get(i).add(new Pair(findNumberByName(nodeData.getBeforeStation()), findNumberByName(nodeData.getNextStation()), cost));
            }
        }
    }

    private static String findNameByNumber(int number) {
        return StationRepository.stations().get(number).getName();
    }

    private static int findNumberByName(String name) {
        for (int i = 0; i < stationSize; i++) {

            if (StationRepository.stations().get(i).getName().equals(name)) {
                return i;
            }
        }

        return Constants.ERROR_CODE;
    }

    private static int selectDistanceOrTime(String select, NodeData nodeData) {
        if (select.equals(Constants.FUNCTION_ONE)) {
            return nodeData.getDistanceCost();
        }
        if (select.equals(Constants.FUNCTION_TWO)) {
            return nodeData.getTimeCost();
        }

        return Constants.ERROR_CODE;
    }

    public static class Pair implements Comparable<Pair> {
        int start, end, cost;

        Pair(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.cost - o.cost;
        }
    }
}
