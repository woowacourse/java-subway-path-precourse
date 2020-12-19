package subway.view.routefindoutput;

import subway.domain.Station;
import subway.view.InformationView;

import java.util.List;

public class RouteFindInformationView extends InformationView {
    private static final String BORDER_LINE = "---";
    private static final String TOTAL_DISTANCE = "총 거리: ";
    private static final String TOTAL_TIME = "총 소요 시간: ";

    public static void printRouteInformation(List<Station> shortestPath) {
        printInfo(BORDER_LINE);
        printInfo(TOTAL_DISTANCE);
        printInfo(TOTAL_TIME);
        printInfo(BORDER_LINE);
        for(Station stationInPath : shortestPath) {
            printInfo(stationInPath.getName());
        }
        System.out.println();
    }
}
