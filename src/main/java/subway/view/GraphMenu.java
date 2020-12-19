package subway.view;

import subway.controller.SubwayController;
import subway.domain.*;
import subway.exception.SameStationException;

import java.util.List;
import java.util.Scanner;

public class GraphMenu {

    private static final String HELLO = "## 경로 기준";

    private static final String DISTANCE_SELECTION = "1";
    private static final String TIME_SELECTION = "2";
    private static final String BACK_SELECTION = "B";

    private static final String DISTANCE_DESCRIPTION = "최단 거리";
    private static final String TIME_DESCRIPTION = "최소 시간";
    private static final String BACK_DESCRIPTION = "돌아가기";

    private static final String MENU = HELLO + "\n" + DISTANCE_SELECTION + ". " + DISTANCE_DESCRIPTION + "\n" +
            TIME_SELECTION + ". " + TIME_DESCRIPTION + "\n" + BACK_SELECTION + ". " + BACK_DESCRIPTION;

    private static final String CHOOSE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private static final String CHOOSE_START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String CHOOSE_END_STATION_MESSAGE = "## 도착역을 입력하세요.";

    private static final String RESULT_MESSAGE = "## 조회 결과";

    private static final String INFO = "[INFO]";

    private static final String TOTAL_DISTANCE = "총 거리";
    private static final String TOTAL_TIME = "총 소요 시간";

    private static final String NOT_VALID_INPUT_ERROR = "[ERROR] 그 기능은 사용할 수 없습니다.";
    private static final String STATION_NOT_EXIST_ERROR = "[ERROR] 출발역과 도착역 중에 없는 역이 존재합니다.";
    private static final String SAME_TERMINAL_ERROR = "[ERROR] 출발역과 도착역이 같습니다.";

    private static final List<String> SELECTIONS = List.of(DISTANCE_SELECTION, TIME_SELECTION, BACK_SELECTION);

    private final Scanner scanner;
    private final SubwayController subwayController = new SubwayController();

    public GraphMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMenu() {
        while (true) {
            System.out.println(MENU + "\n" + CHOOSE_MESSAGE);
            String select = scanner.next();

            if (!validInput(select)) {
                System.out.println(NOT_VALID_INPUT_ERROR + "\n");
            } else if (select.equals(BACK_SELECTION)) {
                break;
            } else if (select.equals(DISTANCE_SELECTION)) {
                printPath(GraphType.DISTANCE);
            } else if (select.equals(TIME_SELECTION)) {
                printPath(GraphType.TIME);
            }
        }
    }


    private void printPath(GraphType graphType) {

        System.out.println(CHOOSE_START_STATION_MESSAGE);
        String startStationName = scanner.next();
        System.out.println("\n" + CHOOSE_END_STATION_MESSAGE);
        String endStationName = scanner.next();

        if (checkValid(startStationName, endStationName)) {
            System.out.println(resultToString(getGraphInfo(startStationName, endStationName, graphType)));
        }
    }

    private GraphDTO getGraphInfo(String startStationName, String endStationName, GraphType graphType) {
        List<Station> path = getPath(startStationName, endStationName, graphType);
        int time = getWeight(startStationName, endStationName, GraphType.TIME);
        int distance = getWeight(startStationName, endStationName, GraphType.DISTANCE);

        return new GraphDTO(distance, time, path);
    }

    private String resultToString(GraphDTO dto) {

        StringBuilder sb = new StringBuilder();

        sb.append(RESULT_MESSAGE).append(INFO).append(" \n---");
        sb.append(INFO).append(" ").append(TOTAL_DISTANCE).append(": ").append(dto.getDistance()).append("km\n");

        sb.append(INFO).append(" ").append(TOTAL_TIME).append(": ").append(dto.getTime()).append("분\n");
        sb.append("---\n");

        for (Station station : dto.getPath()) {
            sb.append(INFO).append(" ").append(station.getName()).append("\n");
        }
        return sb.toString();
    }

    private List<Station> getPath(String startStationName, String endStationName, GraphType graphType) {
        Station startStation = StationRepository.findStationByName(startStationName);
        Station endStation = StationRepository.findStationByName(endStationName);
        return subwayController.getShortestPath(startStation, endStation, graphType);
    }

    private int getWeight(String startStationName, String endStationName, GraphType graphType) {
        Station startStation = StationRepository.findStationByName(startStationName);
        Station endStation = StationRepository.findStationByName(endStationName);
        return (int) subwayController.getShortestPathWeight(startStation, endStation, graphType);
    }

    private boolean checkValid(String startStationName, String endStationName) {

        if (!existStation(startStationName) || !existStation(endStationName)) {
            System.out.println(STATION_NOT_EXIST_ERROR + "\n");
            return false;
        } else if (startStationName.equals(endStationName)) {
            System.out.println(SAME_TERMINAL_ERROR + "\n");
            return false;
        }
        return true;
    }

    private boolean existStation(String stationName) {
        if (StationRepository.contains(stationName)) {
            return true;
        }
        return false;
    }


    private boolean validInput(String select) {
        return SELECTIONS.contains(select);
    }


}
