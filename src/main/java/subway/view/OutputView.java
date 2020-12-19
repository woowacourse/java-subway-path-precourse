package subway.view;

import java.util.List;
import subway.domain.Station.Station;
import subway.domain.selector.menu.Menu;

public class OutputView {

    private static final String INFORMATION_TAG = "[INFO]";
    private static final String LINE_STATION_SEPARATOR = "---";
    private static final String SCREEN_MESSAGE_START = "\n## ";
    private static final String ID_SEPARATOR = ". ";

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
        System.out.println("\n[INFO] ---");
        System.out.println("[INFO] 총거리: " + Math.round(distance) + "km");
    }

    public static void printTravelTime(double travelTime) {
        System.out.println("[INFO] 총 소요 시간: " + Math.round(travelTime) + " 분");
    }

    public static void printStations(List<Station> shortestPath) {
        System.out.println("[INFO] ---");
        for (Station station : shortestPath) {
            System.out.println("[INFO] " + station.getName());
        }
    }


}
