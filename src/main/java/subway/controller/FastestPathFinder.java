package subway.controller;

import subway.Exception.CustomException;
import subway.domain.DistanceRepository;
import subway.view.InputView;

import java.util.List;
import java.util.Scanner;

public class FastestPathFinder {
    public static final String PREFIX_START_STATION = "start";
    private static final String PREFIX_END_STATION = "end";
    private final Scanner scanner;

    public FastestPathFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String startStation = askValidStation(PREFIX_START_STATION);
        String endStation = askValidStation(PREFIX_END_STATION);
        try {
            Validate.notSameStation(startStation, endStation);
            printFastestPath(startStation, endStation);
        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void printFastestPath(String startStation, String endStation) {
        int length = DistanceRepository.getFastestPathLength(startStation, endStation);
        List<String> pathList = DistanceRepository.getFastestPath(startStation, endStation);

        StringBuilder sb = new StringBuilder();
        sb.append("\n## 조회 결과");
        sb.append("\n[INFO] ---");
        sb.append("\n[INFO] 총 거리: " + length + "km");
        sb.append("\n[INFO] ---");
        for (String station : pathList) {
            sb.append("\n[INFO]");
            sb.append(station);
        }
        System.out.println(sb);
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
