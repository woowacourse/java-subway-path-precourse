package subway;

import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PathMenu {
    private static final String SHORTEST_DISTANCE = "1";
    private static final String SHORTEST_TIME = "2";
    private static final String BACK = "B";
    private static final String PATH_MENU = "PATH MENU";

    public static void initialize(Scanner scanner) {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(SHORTEST_DISTANCE, SHORTEST_TIME, BACK));
        while (true) {
            showOptions();
            String result = start(scanner, authorizedCommands);
            if (result.equals(BACK)) {
                break;
            }
        }
    }

    private static String start(Scanner scanner, List<String> authorizedCommands) {
        try {
            String command = getCommand(scanner, authorizedCommands);
            if (command.equals(BACK)) {
                return command;
            }
            execute(command, scanner);
        } catch (Exception exception) {
            System.out.println("[ERROR] " + exception.getMessage() + "\n");
            return PATH_MENU;
        }
        return BACK;
    }

    private static void execute(String command, Scanner scanner) throws IllegalArgumentException {
        String startStation = getStartStation(scanner);
        String endStation = getEndStation(scanner, startStation);
        List<String> shortestPath = PathFinder.getShortestPath(command, startStation, endStation);
        showResults(shortestPath);
    }

    private static void showResults(List<String> shortestPath) {
        int totalDistance = PathFinder.getTotalDistance(shortestPath);
        int totalTime = PathFinder.getTotalTime(shortestPath);
    }


    private static String getEndStation(Scanner scanner, String startStation) {
        System.out.println("## 출발역을 입력하세요.");
        String stationName = getStation(scanner);
        if (stationName.equals(startStation)) {
            throw new IllegalArgumentException("출발역과 도착역이 동일합니다.");
        }
        return stationName;
    }

    private static String getStation(Scanner scanner) throws IllegalArgumentException {
        String stationName = scanner.nextLine();
        System.out.println();
        if (!StationRepository.contains(stationName)) {
            throw new IllegalArgumentException("등록되어 있지 않은 역입니다.");
        }
        return stationName;
    }


    private static String getStartStation(Scanner scanner) throws IllegalArgumentException {
        System.out.println("## 출발역을 입력하세요.");
        String stationName = getStation(scanner);
        return stationName;
    }

    private static String getCommand(Scanner scanner, List<String> authorizedCommands) throws IllegalArgumentException {
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();
        if (!authorizedCommands.contains(userInput)) {
            throw new IllegalArgumentException("없는 기능입니다.");
        }
        return userInput;
    }

    private static void showOptions() {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기\n");
    }
}
