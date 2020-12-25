package subway;

import subway.domain.Edge;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.*;

public class ShortestDistance {

    private ArrayList<Edge>[] subwayNetwork;
    private Map<Station, Integer> stationMapper;
    private int[] parent;
    private int[] distance;
    private int[] time;
    private InputView inputView = InputView.getInstance();
    private static final int INFINITY = Integer.MAX_VALUE;
    private Map<Integer, Station> convertedMapper = new HashMap<>();

    public ShortestDistance(Map<Station, Integer> stationMapper,
                                ArrayList<Edge>[] subwayNetwork) {
        this.subwayNetwork = subwayNetwork;
        this.stationMapper = stationMapper;
        for (Map.Entry<Station, Integer> entry : stationMapper.entrySet()) {
            convertedMapper.put(entry.getValue(), entry.getKey());
        }
    }

    public void calculateShortestDistance() {
        try {
            Station startStation = new Station(inputView.inputStartStationToShortestDistance());
            if (!stationMapper.containsKey(startStation)) {
                throw new IllegalArgumentException("[ERROR] 등록되지 않은 역입니다.");
            }
            selectEndStation(startStation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            calculateShortestDistance();
        }
    }

    private void selectEndStation(Station startStation) {
        try {
            Station endStation = new Station(inputView.inputEndStationToShortestDistance());
            if (!stationMapper.containsKey(endStation)) {
                throw new IllegalArgumentException("[ERROR] 등록되지 않은 역입니다.");
            }
            if (startStation.equals(endStation)) {
                throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 같습니다.");
            }
            calculateDistance(startStation, endStation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectEndStation(startStation);
        }
    }

    private void calculateDistance(Station startStation, Station endStation) {
        int startNumber = stationMapper.get(startStation);
        int endNumber = stationMapper.get(endStation);
        initDistance(startNumber);
        initTime(startNumber);
        initParent();
        doDijkstra(startNumber);
        OutputView.printTotalDistanceAndTime(distance[endNumber], time[endNumber]);
        OutputView.printRouteList(convertedMapper, parent, endNumber);
    }

    private void initDistance(int start){
        distance = new int[stationMapper.size()+1];
        for( int i=1; i<=stationMapper.size(); i++ ){
            if( i != start ) distance[i] = INFINITY;
        }
    }

    private void initTime(int start){
        time = new int[stationMapper.size()+1];
        for( int i=1; i<=stationMapper.size(); i++ ){
            if( i != start ) time[i] = INFINITY;
        }
    }

    private void initParent(){
        parent = new int[stationMapper.size()+1];
        for( int i=1; i<=stationMapper.size(); i++ ){
            parent[i] = i;
        }
    }

    private void doDijkstra(int start){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });
        priorityQueue.add(new Edge(start, 0, 0));
        while(!priorityQueue.isEmpty()){
            Edge temp = priorityQueue.poll();
            int currentStation = temp.getEndStation();
            int currentDistance = temp.getDistance();
            int currentTime = temp.getTime();
            if (distance[currentStation] < currentDistance) continue;
            for( Edge n : subwayNetwork[currentStation] ){
                if( distance[n.getEndStation()] > currentDistance + n.getDistance() ){
                    parent[n.getEndStation()] = currentStation;
                    distance[n.getEndStation()] = currentDistance + n.getDistance();
                    time[n.getEndStation()] = currentTime + n.getTime();
                    priorityQueue.add(new Edge(n.getEndStation(), distance[n.getEndStation()], time[n.getEndStation()]));
                }
            }
        }
    }
}
