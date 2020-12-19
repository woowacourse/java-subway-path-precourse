package subway.view;

import java.util.List;
import subway.domain.Station.Station;
import subway.domain.selector.menu.Menu;

public class OutputView {

    private static final String INFORMATION_TAG = "[INFO]";
    private static final String LINE_STATION_SEPARATOR = " ---";
    private static final String SCREEN_MESSAGE_START = "\n## ";
    private static final String ID_SEPARATOR = ". ";
    private static final String DISTANCE_UNIT = "km";
    private static final String MINUTE_UNIT = " 분";
    private static final String TOTAL_DISTANCE_MESSAGE = " 총거리: ";
    private static final String TOTAL_TIME_MESSAGE = " 총 소요 시간: ";


    public static void printScreen(Menu menu) {
        System.out.println(SCREEN_MESSAGE_START + menu);
        printMenus(menu);
        printItems(menu);
        System.out.println();
    }

    private static void printMenus(Menu menu) {
        for (String key : menu.getMenus().keySet()) {
            System.out.println(key + ID_SEPARATOR + menu.getMenus().get(key));
        }
    }

    private static void printItems(Menu menu) {
        for (String key : menu.getItems().keySet()) {
            System.out.println(key + ID_SEPARATOR + menu.getItems().get(key));
        }
    }

    public static void printDistance(double distance) {
        System.out.println("\n" + INFORMATION_TAG + LINE_STATION_SEPARATOR);
        System.out.println(INFORMATION_TAG + TOTAL_DISTANCE_MESSAGE + Math.round(distance) + DISTANCE_UNIT);
    }

    public static void printTravelTime(double travelTime) {
        System.out.println(INFORMATION_TAG + TOTAL_TIME_MESSAGE + Math.round(travelTime) + MINUTE_UNIT);
    }

    public static void printStations(List<Station> shortestPath) {
        System.out.println(INFORMATION_TAG + LINE_STATION_SEPARATOR);
        for (Station station : shortestPath) {
            System.out.println(INFORMATION_TAG + " " + station.getName());
        }
    }


}
