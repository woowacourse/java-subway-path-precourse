package subway.view;

import subway.util.Validator;

import java.util.Scanner;

public class InputView extends Validator {
    private static final String OPTION_SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String ARRIVED_STATION_MESSAGE = "## 도착역을 입력하세요.";
    private static Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String inputMainMenuOption() {
        System.out.println(OPTION_SELECT_MESSAGE);
        String option = scanner.nextLine();
        validateMainMenuOption(option);
        return option;
    }

    public static String inputPathMenuOption() {
        System.out.println(OPTION_SELECT_MESSAGE);
        String option = scanner.nextLine();
        validatePathMenuOption(option);
        return option;
    }

    public static String inputStartStation() {
        System.out.println(START_STATION_MESSAGE);
        String startStationName = scanner.nextLine();
        validateStartStation(startStationName);
        return startStationName;
    }

    public static String inputEndStation(String startStationName) {
        System.out.println(ARRIVED_STATION_MESSAGE);
        String endStationName = scanner.nextLine();
        validateEndStation(endStationName, startStationName);
        return endStationName;
    }
}
