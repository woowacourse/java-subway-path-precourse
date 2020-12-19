package subway.view;

import java.util.Scanner;
import subway.utils.InputValidator;

public class InputView {

    private static final String USER_OPTION_MESSAGE = "## 원하는 기능을 선택하세요";
    private static final String ERROR_PREFIX = "[ERROR]: ";
    private static final String INPUT_DEPARTURE_STATION = "출발역을 입력하세요";
    private static final String INPUT_ARRIVAL_STATION = "도착역을 입력하세요";

    private static Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String inputMainUserOption() {
        System.out.println(USER_OPTION_MESSAGE);
        String userOption = scanner.nextLine().trim();
        try {
            InputValidator.validateMainUserOption(userOption);
            return userOption;
        } catch (Exception e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return inputMainUserOption();
        }
    }

    public static String inputPathUserOption() {
        System.out.println(USER_OPTION_MESSAGE);
        String userOption = scanner.nextLine().trim();
        try {
            InputValidator.validatePathUserOption(userOption);
            return userOption;
        } catch (Exception e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return inputPathUserOption();
        }
    }

    public static String inputDepartureStation() {
        System.out.println(INPUT_DEPARTURE_STATION);
        String stationName = scanner.nextLine().trim();
        try {
            InputValidator.validateStationName(stationName);
            return stationName;
        } catch (Exception e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return inputDepartureStation();
        }
    }

    public static String inputArrivalStation() {
        System.out.println(INPUT_ARRIVAL_STATION);
        String stationName = scanner.nextLine().trim();
        try {
            InputValidator.validateStationName(stationName);
            return stationName;
        } catch (Exception e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return inputArrivalStation();
        }
    }
}
