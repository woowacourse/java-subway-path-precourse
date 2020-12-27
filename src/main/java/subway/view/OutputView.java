package subway.view;

import subway.domain.Station;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printTotalDistanceAndTime(int distance, int time) {
        System.out.println("\n## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: " + distance + "km");
        System.out.println("[INFO] 총 시간: " + time + "분");
        System.out.println("[INFO] ---");
    }

    public static void printRouteList(List<Station> shortestPath) {
        for (Station station : shortestPath) {
            System.out.println(station);
        }

    }

}
