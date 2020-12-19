package subway.domain;

import subway.validator.Validator;

import java.util.List;
import java.util.Scanner;

public class Route {
    private final int SHORTEST_DISTANCE = 1;
    private final int SHORTEST_TIME = 2;
    private Scanner scanner;
    private Station startStation;
    private Station endStation;
    private SubwayGraph subwayGraph = new SubwayGraph();

    public Route(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        String number;
        int chosenNumber;

        System.out.println("## 경로 기준\n" +
                "1. 최단 거리\n" +
                "2. 최소 시간\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");
        number = scanner.next();
        if (!number.equals("B")) {
            chosenNumber = Validator.isInputRight(number);
            getStationName();
            choose(chosenNumber);
        }
    }

    public void choose(int chosenNumber) {
        if (chosenNumber == SHORTEST_DISTANCE) {
            for (String station : findDistanceByDistance()) {
                System.out.println("[INFO] " + station);
            }
            System.out.println("");
        }
        if (chosenNumber == SHORTEST_TIME) {
            for (String station : findDistanceByTime()) {
                System.out.println("[INFO] " + station);
            }
            System.out.println("");
        }
    }

    public List<String> findDistanceByDistance() {
        subwayGraph.setSubwayGraphByDistance();
        return subwayGraph.getShortestPath(startStation, endStation);
    }

    public List<String> findDistanceByTime() {
        subwayGraph.setSubwayGraphByTime();
        return subwayGraph.getShortestPath(startStation, endStation);
    }

    public void getStationName() {
        System.out.println("## 출발역을 입력하세요.");
        String startStationName = scanner.next();
        Validator.isStationExist(startStationName);
        this.startStation = StationRepository.getStationByName(startStationName);

        System.out.println("## 도착역을 입력하세요.");
        String endStationName = scanner.next();
        Validator.isStationExist(endStationName);
        this.endStation = StationRepository.getStationByName(endStationName);

        Validator.isStationEquals(startStationName, endStationName);
    }
}
