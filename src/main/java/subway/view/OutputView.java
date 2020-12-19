package subway.view;

import static subway.SubwayKeyWords.ERROR_STATION_UNREACHABLE;
import static subway.SubwayKeyWords.INFO_LINE;
import static subway.SubwayKeyWords.INFO_STATION_NAME;
import static subway.SubwayKeyWords.INFO_TOTAL_DISTANCE;
import static subway.SubwayKeyWords.INFO_TOTAL_TIME;
import static subway.SubwayKeyWords.RESULT_ANNOUNCEMENT;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import subway.domain.Station;

public class OutputView {

    public static void showOptions(String title, TreeMap options) {
        System.out.println(title);
        Set set = options.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry e = (Map.Entry) iterator.next();
            System.out.printf("%s. %s\n", e.getKey(), e.getValue());
        }
        System.out.println("");
    }


    public static void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
        System.out.println();
    }

    public static void showResult(List<Station> shortestPath, int finalDistance, int finalTime) {
        System.out.println('\n' + RESULT_ANNOUNCEMENT);
        System.out.println(INFO_LINE);
        System.out.printf(INFO_TOTAL_DISTANCE, finalDistance);
        System.out.printf(INFO_TOTAL_TIME, finalTime);
        System.out.println(INFO_LINE);
        for (Station station : shortestPath) {
            System.out.printf(INFO_STATION_NAME, station);
        }
        System.out.println();
    }

    public static void showErrorStationUnreachable() {
        System.out.println(ERROR_STATION_UNREACHABLE);
    }
}
