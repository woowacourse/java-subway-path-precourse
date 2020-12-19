package subway;

import subway.domain.NodeData;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class FindPath {

    private static final int INIT_MIN_VALUE = 0;
    private static final int MAX_VALUE = 99999999;
    private static ArrayList<ArrayList<Pair>> subwayList;
    private static int dist[];
    private static boolean visited[];
    private static int stationSize;
    private static PriorityQueue<Pair> q;

    public static void start(String select, String startStation, String arriveStation) {
        setBeforeDijkstra(select, startStation);
        int value = startDijkstra(startStation, arriveStation);
        System.out.println(value);
        if(value == MAX_VALUE){
            throw new IllegalArgumentException("[ERROR] 연결되어 있지 않은 역입니다.");
        }
        System.out.println(value);
    }

    //depth 2이하로 고치기, 메소드 15줄 이하
    private static int startDijkstra(String startStation, String arriveStation) {
        int startNumber = findNumberByName(startStation);
        int arriveNumber = findNumberByName(arriveStation);
        dist[startNumber] = INIT_MIN_VALUE;
        visited[startNumber] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();

            int start = p.start;

            for(int i=0;i<subwayList.get(start).size();i++){
                int end = subwayList.get(start).get(i).end;
                int cost = subwayList.get(start).get(i).cost;
                if(!visited[end]){
                    if(dist[end] > dist[start] + cost){
                        dist[end] = dist[start] + cost;
                        q.add(new Pair(end, 0, dist[end]));
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

        return -1;
    }

    private static int selectDistanceOrTime(String select, NodeData nodeData) {
        if (select.equals(Constants.FUNCTION_ONE)) {
            return nodeData.getDistanceCost();
        }
        if (select.equals(Constants.FUNCTION_TWO)) {
            return nodeData.getTimeCost();
        }

        return 0;
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
