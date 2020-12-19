package subway.view;

import subway.menuSelection.MainMenuSelection;
import subway.menuSelection.PathStandardSelection;

import java.util.Scanner;

public class InputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String REQUEST_SELECTION = "원하는 기능을 선택하세요.";
    private static final String REQUEST_DEPART_STATION = "출발역을 입력하세요";
    private static final String REQUEST_ARRIVAL_STATION = "도착역을 입력하세요";
    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static MainMenuSelection getMainMenuSelection() {
        System.out.println(SHARP_PREFIX + REQUEST_SELECTION);
        return MainMenuSelection.searchByKey(scanner.nextLine().toUpperCase());
    }

    public static PathStandardSelection getPathStandardSelection() {
        System.out.println(SHARP_PREFIX + REQUEST_SELECTION);
        return PathStandardSelection.searchByKey(scanner.nextLine().toUpperCase());
    }

    public static String getDepartureStationName() {
        System.out.println(SHARP_PREFIX + REQUEST_DEPART_STATION);
        return scanner.nextLine();
    }

    public static String getArrivalStationName() {
        System.out.println(SHARP_PREFIX + REQUEST_ARRIVAL_STATION);
        return scanner.nextLine();
    }
}
