package subway.view;

import java.util.List;
import subway.controller.Choice;
import subway.domain.Station;

public class OutputView {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String INFO_MESSAGE_PREFIX = "[INFO] ";
    private static final String RESULT_LINE_DELIMETER = "---";
    private static final String SHOW_RESULT_MESSAGE = "조회 결과";
    
    public static void printMenu(String title, List<Choice> choices) {
        System.out.println(ViewConstants.NEW_MESSAGE_PREFIX + title);
        for (Choice choice : choices) {
            System.out.println(choice.toString());
        }
        System.out.println(ViewConstants.EMPTY_LINE);
    }
    
    public static void printErrorMessage(Exception exception) {
        System.out.println(ERROR_MESSAGE_PREFIX + exception.getMessage());
        System.out.println(ViewConstants.EMPTY_LINE);
    }
    
    public static void printStations(List<Station> stations) {
        System.out.println(ViewConstants.NEW_MESSAGE_PREFIX + SHOW_RESULT_MESSAGE);
        System.out.println(INFO_MESSAGE_PREFIX + RESULT_LINE_DELIMETER);
        for (Station station : stations) {
            System.out.println(INFO_MESSAGE_PREFIX + station.getName());
        }
        System.out.println(ViewConstants.EMPTY_LINE);
    }
}
