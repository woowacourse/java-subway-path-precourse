package subway.controller;

import subway.Exception.CustomException;
import subway.domain.DistanceRepository;
import subway.view.InputView;

import java.util.List;
import java.util.Scanner;


public class ShortestPathFinder {
    public static final String PREFIX_START_STATION = "start";
    private static final String PREFIX_END_STATION = "end";
    public static final String NEW_LINE = "\n";
    public static final String PATH_RESULT = "## 조회 결과";
    public static final String PREFIX_INFO = "[INFO] ";
    public static final String HORIZONTAL_LINE = "---";
    public static final String PREFIX_TIME = "총 소요시간: ";
    public static final String PREFIX_DISTANCE = "총 거리 : ";
    public static final String SUFFIX_TIME = "분";
    public static final String SUFFIX_DISTANCE = "km";
    private final Scanner scanner;

    public ShortestPathFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String startStation = askValidStation(PREFIX_START_STATION);
        String endStation = askValidStation(PREFIX_END_STATION);
        try {
            Validate.notSameStation(startStation, endStation);
            printShortestPath(startStation, endStation);
        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
            run();
        }
    }

    private void printShortestPath(String startStation, String endStation) {
        int shortestLenth = DistanceRepository.getShortestPathLength(startStation, endStation);
        List<String> pathList = DistanceRepository.getShortestPath(startStation, endStation);
        int timeLength = DistanceRepository.getLengthByTime(pathList);

        StringBuilder sb = getStringBuilder(shortestLenth, pathList, timeLength);
        System.out.println(sb);
    }

    private StringBuilder getStringBuilder(int shortestLenth, List<String> pathList, int timeLength) {
        StringBuilder sb = new StringBuilder();
        sb.append(NEW_LINE + PATH_RESULT);
        sb.append(NEW_LINE + PREFIX_INFO + HORIZONTAL_LINE);
        sb.append(NEW_LINE + PREFIX_DISTANCE + shortestLenth + SUFFIX_DISTANCE);
        sb.append(NEW_LINE + PREFIX_TIME + timeLength + SUFFIX_TIME);
        sb.append("\n[INFO] ---");
        for (String station : pathList) {
            sb.append(NEW_LINE + PREFIX_INFO);
            sb.append(station);
        }
        return sb;
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
