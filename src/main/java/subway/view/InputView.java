package subway.view;

import java.util.Scanner;

public class InputView {

    private static final String FUNCTION_CHOOSE = "## 원하는 기능을 선택하세요.";
    private static final String STARTING_STATION_CHOOSE = "## 출발역을 입력하세요.";
    private static final String FINISHING_STATION_CHOOSE = "## 도착역을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputFunction() {
        return userStringInput(FUNCTION_CHOOSE);
    }

    public String inputStartingStationName() {
        return userStringInput(STARTING_STATION_CHOOSE);
    }

    public String inputFinishingStationName() {
        return userStringInput(FINISHING_STATION_CHOOSE);
    }

    private String userStringInput(String specificInfo) {
        System.out.println();
        System.out.println(specificInfo);
        return scanner.nextLine().trim();
    }
}
