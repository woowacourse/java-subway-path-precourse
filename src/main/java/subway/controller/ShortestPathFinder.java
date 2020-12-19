package subway.controller;

import subway.Exception.CustomException;
import subway.view.InputView;

import java.util.Scanner;

public class ShortestPathFinder {
    private final Scanner scanner;

    public ShortestPathFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String startStation = askValidStation("start");
        String endStation = askValidStation("end");
        System.out.println("입력하신 역은 " + startStation);
        System.out.println("입력하신 역은 " + endStation);
    }

    private String askValidStation(String stationPrefix) {
        try {
            return InputView.askStation(scanner, stationPrefix);
        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
            return askValidStation(stationPrefix);
        }
    }
}
