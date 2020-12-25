package subway.view;

import subway.domain.Station;

import java.util.Map;

public class OutputView {

    public static void printTotalDistanceAndTime(int distance, int time) {
        System.out.println("\n## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: " + distance + "km");
        System.out.println("[INFO] 총 시간: " + time + "분");
        System.out.println("[INFO] ---");
    }

    public static void printRouteList(Map<Integer, Station> convertedMapper,
                                            int[] parent, int index) {
        if( index == parent[index] ){
            System.out.println(convertedMapper.get(index));
            return;
        }
        printRouteList(convertedMapper, parent, parent[index]);
        System.out.println(convertedMapper.get(index));
    }

}
