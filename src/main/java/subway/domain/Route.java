package subway.domain;

import java.util.Scanner;

public class Route {
    private Scanner scanner;
    private Station startStation;
    private Station endStation;

    public Route(Scanner scanner) {
        this.scanner = scanner;
    }

    public void findDistanceByDistance() {

    }

    public void findDistanceByTime() {

    }

    public void getStationName() {
        System.out.println("## 출발역을 입력하세요.");
        this.startStation = StationRepository.getStationByName(scanner.next());

        System.out.println("## 도착역을 입력하세요.");
        this.endStation = StationRepository.getStationByName(scanner.next());
    }

}
