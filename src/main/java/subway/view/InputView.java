package subway.view;

import subway.station.model.Station;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String INPUT_ARRIVAL_STATION_MESSAGE = "## 도착역을 입력하세요.";
    private static final String INPUT_WANTED_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static String inputValue(Scanner scanner) {
        System.out.println(INPUT_WANTED_FUNCTION_MESSAGE);
        return scanner.nextLine();
    }

    public static Station inputStartStation(Scanner scanner) {
        System.out.println(INPUT_START_STATION_MESSAGE);
        return inputStation(scanner);
    }

    public static Station inputArrivalStation(Scanner scanner) {
        System.out.println(INPUT_ARRIVAL_STATION_MESSAGE);
        return inputStation(scanner);
    }

    private static Station inputStation(Scanner scanner) {
        try {
            return new Station(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputStation(scanner);
        }
    }
}
