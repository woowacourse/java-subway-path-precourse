package subway.view;

import subway.domain.CommandType;
import subway.domain.SearchType;

import java.util.Scanner;

public class InputView {
    private static final String CHOICE_GUIDE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String STATION_INPUT_GUIDE_MESSAGE_PREFIX = "## ";
    private static final String STATION_INPUT_GUIDE_MESSAGE_SUFFIX = "역을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public CommandType inputCommandNumber() {
        System.out.println(CHOICE_GUIDE_MESSAGE);
        String userMessage = inputWithTrimming();
        lineFeed();
        return CommandType.of(userMessage);
    }

    public SearchType inputSearchNumber() {
        System.out.println(CHOICE_GUIDE_MESSAGE);
        String userMessage = inputWithTrimming();
        lineFeed();
        return SearchType.of(userMessage);
    }

    public String inputStationName(String STATION_TYPE) {
        String message = STATION_INPUT_GUIDE_MESSAGE_PREFIX + STATION_TYPE
                + STATION_INPUT_GUIDE_MESSAGE_SUFFIX;
        System.out.println(message);
        String userMessage = inputWithTrimming();
        lineFeed();
        return userMessage;
    }

    private String inputWithTrimming() {
        return scanner.nextLine().trim();
    }

    private void lineFeed() {
        System.out.println();
    }
}
