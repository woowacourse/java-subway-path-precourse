package subway.view.inputview;

import subway.view.InputView;
import subway.view.utils.InputValidator;

import java.util.Scanner;

public class PathView extends InputView {
    private static PathView pathView;
    private static final String PATH_VIEW = "## 경로 기준";
    private static final String SHORTEST_PATH = "1. 최단 거리";
    private static final String MINIMUM_TIME = "2. 최소 시간";
    private static final String BACK = "B. 돌아가기";
    private static final String INPUT_PATTERN = "^[1-2B]$";
    private static final String PLEASE_INPUT_DEPARTURE_STATION = "## 출발역을 입력하세요.";
    private static final String PLEASE_INPUT_ARRIVAL_STATION = "## 도착역을 입력하세요.";

    public PathView(Scanner scanner) {
        super(scanner);
    }

    public static PathView getInstance(Scanner scanner) {
        if (pathView == null) {
            pathView = new PathView(scanner);
        }

        return pathView;
    }

    @Override
    public String inputCommand() {
        System.out.println(PLEASE_INPUT_COMMAND);
        String command = super.scanner.nextLine().trim().toUpperCase();
        System.out.println();
        InputValidator.validateEmpty(command);
        InputValidator.validatePattern(INPUT_PATTERN, command);
        return command;
    }

    @Override
    public void showOption() {
        System.out.println(PATH_VIEW);
        System.out.println(SHORTEST_PATH);
        System.out.println(MINIMUM_TIME);
        System.out.println(BACK);
        System.out.println();
    }

    public String inputDepartureStation() {
        System.out.println(PLEASE_INPUT_DEPARTURE_STATION);
        String stationName = super.scanner.nextLine().trim().toUpperCase();
        System.out.println();
        InputValidator.validateEmpty(stationName);
        return stationName;
    }

    public String inputArrivalStation() {
        System.out.println(PLEASE_INPUT_ARRIVAL_STATION);
        String stationName = super.scanner.nextLine().trim().toUpperCase();
        System.out.println();
        InputValidator.validateEmpty(stationName);
        return stationName;
    }
}
