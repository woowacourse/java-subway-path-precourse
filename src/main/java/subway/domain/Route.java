package subway.domain;

import subway.validator.Validator;

import java.util.List;
import java.util.Scanner;

public class Route {
    private Scanner scanner;
    private Station startStation;
    private Station endStation;
    private SubwayGraph subwayGraph = new SubwayGraph();

    public Route(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        String number;
        System.out.println("## 경로 기준\n" +
                "1. 최단 거리\n" +
                "2. 최소 시간\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");
        number = scanner.next();

        getStationName();

        if (number.equals("1")) {
            for (String station : findDistanceByDistance()) {
                System.out.println("[INFO] " + station);
            }
        }
        if (number.equals("2")) {
            for (String station : findDistanceByTime()) {
                System.out.println("[INFO] " + station);
            }
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
    }
}
