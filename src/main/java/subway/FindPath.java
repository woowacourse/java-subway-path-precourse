package subway;

import subway.domain.NodeData;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPath {

    private static ArrayList<ArrayList<Pair>> subwayList;
    private static int dist[];
    private static int stationSize;

    public static void start(String select, String startStation, String arriveStation) {
        setBeforeDijkstra(select);
    }

    private static void setBeforeDijkstra(String select) {
        subwayList = new ArrayList<ArrayList<Pair>>();
        stationSize = StationRepository.getSize();
        setSubwayList(select);
        dist = new int[stationSize];

        Arrays.fill(dist, Integer.MAX_VALUE);
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
        int s, e, cost;

        Pair(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.cost - o.cost;
        }
    }
}
