package subway.view;

import subway.util.Validator;

import java.util.Scanner;

public class InputView extends Validator {
    private static final String OPTION_SELECT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputMainMenuOption() {
        System.out.println(OPTION_SELECT_MESSAGE);
        String option = scanner.nextLine();
        validateMainMenuOption(option);
        return option;
    }

    public String inputPathMenuOption() {
        System.out.println(OPTION_SELECT_MESSAGE);
        String option = scanner.nextLine();
        validatePathMenuOption(option);
        return option;
    }

    public String inputStartStation() {
        System.out.println(START_STATION_MESSAGE);
        String station = scanner.nextLine();
        //validate exist station
        return station;
    }
}
