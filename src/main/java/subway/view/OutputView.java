package subway.view;

import java.util.List;
import subway.controller.Choice;
import subway.domain.Station;

public class OutputView {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String INFO_MESSAGE_PREFIX = "[INFO] ";
    private static final String RESULT_LINE_DELIMETER = "---";
    private static final String SHOW_RESULT_MESSAGE = "조회 결과";
    private static final String TOTAL_DISTANCE_ATTRIBUTE = "총 거리: ";
    private static final String TOTAL_TIME_ATTRIBUTE = "총 시간: ";
    private static final String DISTANCE_UNIT = "km";
    private static final String TIME_UNIT = "분";
    
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
    
    public static void printPath(List<Station> stations, int totalDistance, int totalTime) {
        System.out.println(ViewConstants.NEW_MESSAGE_PREFIX + SHOW_RESULT_MESSAGE);
        System.out.println(INFO_MESSAGE_PREFIX + RESULT_LINE_DELIMETER);
        System.out.println(INFO_MESSAGE_PREFIX + TOTAL_DISTANCE_ATTRIBUTE + totalDistance + DISTANCE_UNIT);
        System.out.println(INFO_MESSAGE_PREFIX + TOTAL_TIME_ATTRIBUTE + totalTime + TIME_UNIT);
        System.out.println(INFO_MESSAGE_PREFIX + RESULT_LINE_DELIMETER);
        for (Station station : stations) {
            System.out.println(INFO_MESSAGE_PREFIX + station.getName());
        }
        System.out.println(ViewConstants.EMPTY_LINE);
    }
}
