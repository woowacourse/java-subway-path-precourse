package subway.domain;

import subway.validator.Validator;

import java.util.List;
import java.util.Scanner;

public class Route {
    private final int SHORTEST_DISTANCE = 1;
    private final int SHORTEST_TIME = 2;
    private final int INITIALIZATION = 0;
    private final int INDEX_BOUNDARY_NUMBER = 1;
    private final int NEXT_STATION_NUMBER = 1;
    private Scanner scanner;
    private Station startStation;
    private Station endStation;
    private SubwayGraph subwayDistanceGraph = new SubwayGraph();
    private SubwayGraph subwayTimeGraph = new SubwayGraph();

    public Route(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        String number;
        int chosenNumber;

        System.out.println("\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기\n\n## 원하는 기능을 선택하세요.");
        number = scanner.next();
        if (!number.equals("B")) {
            chosenNumber = Validator.isInputRight(number);
            getStationName();
            choose(chosenNumber);
        }
    }

    private void choose(int chosenNumber) {
        List<String> subwayDistanceGraph = findDistanceByDistance();
        List<String> subwayTimeGraph = findDistanceByTime();

        if (chosenNumber == SHORTEST_DISTANCE) {
            getDistanceAndTimeSum(subwayDistanceGraph);
            for (String station : subwayDistanceGraph) {
                System.out.println("[INFO] " + station);
            }
            System.out.println("");
        }
        if (chosenNumber == SHORTEST_TIME) {
            getDistanceAndTimeSum(subwayTimeGraph);
            for (String station : subwayTimeGraph) {
                System.out.println("[INFO] " + station);
            }
            System.out.println("");
        }
    }

    private List<String> findDistanceByDistance() {
        subwayDistanceGraph.setSubwayGraphByDistance();
        return subwayDistanceGraph.getShortestPath(startStation, endStation);
    }

    public List<String> findDistanceByTime() {
        subwayTimeGraph.setSubwayGraphByTime();
        return subwayTimeGraph.getShortestPath(startStation, endStation);
    }

    private void getStationName() {
        System.out.println("\n## 출발역을 입력하세요.");
        String startStationName = scanner.next();
        Validator.isStationExist(startStationName);
        this.startStation = StationRepository.getStationByName(startStationName);

        System.out.println("\n## 도착역을 입력하세요.");
        String endStationName = scanner.next();
        Validator.isStationExist(endStationName);
        this.endStation = StationRepository.getStationByName(endStationName);

        Validator.isStationEquals(startStationName, endStationName);
    }

    private void getDistanceAndTimeSum(List<String> shortestPath) {
        int distance = INITIALIZATION;
        int time = INITIALIZATION;

        for (int i = 0; i < shortestPath.toArray().length - INDEX_BOUNDARY_NUMBER; i++) {
            distance = distance + subwayDistanceGraph.getDistanceBetweenTwoStation(shortestPath.get(i), shortestPath.get(i + NEXT_STATION_NUMBER));
            time = time + subwayTimeGraph.getDistanceBetweenTwoStation(shortestPath.get(i), shortestPath.get(i + NEXT_STATION_NUMBER));
        }

        System.out.println("\n## 조회 결과\n" +
                "[INFO] ---\n" +
                "[INFO] 총 거리: " + distance + "km\n" +
                "[INFO] 총 소요 시간: " + time + "분\n" +
                "[INFO] ---");
    }
}
