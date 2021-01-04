package subway.view;

import subway.exception.SubwayException;

import java.util.List;

public class OutputView {
    
    public static void printQuestion(String message) {
        System.out.println();
        System.out.printf("%s %s\n", TextCollection.PREFIX, message);
    }

    public static void printInformation(String information) {
        System.out.println(TextCollection.INFO_TAG + information);
    }

    public static void printErrorMessage(SubwayException exception) {
        System.out.println();
        System.out.println(exception.getMessage());
    }

    public static void printShortestPathInfo(int distance, int time) {
        printInformation(TextCollection.SEPARATOR);
        printInformation(String.format(TextCollection.TOTAL_DISTANCE_MESSAGE, distance));
        printInformation(String.format(TextCollection.TOTAL_TIME_MESSAGE, time));
        printInformation(TextCollection.SEPARATOR);
    }

    public static void printStations(List<String> stations) {
        stations.forEach(station -> printInformation(station));
        System.out.println();
    }
}
