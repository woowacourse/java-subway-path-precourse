package subway.output;

import java.util.List;
import subway.repository.SectionRepository;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class OutputView {
    public static final String EQUALS_STATION_ERROR = "[ERROR] 출발역과 도착역이 동일합니다.";
    public static final String RESULT = "\n## 조회 결과";
    public static final String RESULT_EXPRESS = "[INFO] ---\n";
    public static final String INFO = "[INFO] ";
    public static final String TOTAL_DISTANCE = "총 거리";
    public static final String TOTAL_TIME = "총 소요시간";

    public static void printPage(List<String> mainPageItem) {
        for (String item : mainPageItem) {
            System.out.println(item);
        }
    }

    public static void printStartStationEqualsFinishStationError() {
        System.out.println(EQUALS_STATION_ERROR);
    }

    public static void printShortestDistanceResult(List<String> shortestDistanceStations) {
        System.out.println(RESULT);
        System.out.println(RESULT_EXPRESS);
        System.out.println(INFO + TOTAL_DISTANCE);
        System.out.println(INFO + TOTAL_TIME);
        System.out.println(RESULT_EXPRESS);
        for (String stationName : shortestDistanceStations) {
            System.out.println(INFO + stationName);
        }
    }

    public static void printMinimumTimeStations(List<String> minimumTimeStations) {
        System.out.println(RESULT);
        System.out.println(RESULT_EXPRESS);
        System.out.println(INFO + TOTAL_DISTANCE);
        System.out.println(INFO + TOTAL_TIME);
        System.out.println(RESULT_EXPRESS);
        for (String stationName : minimumTimeStations) {
            System.out.println(INFO + stationName);
        }
    }
    //todo : 최소 시간, 최소 거리 구현

    private static String getTotalDistance(List<String> shortestDistanceStations) {
        return SectionRepository.findTotalDistance(shortestDistanceStations);
    }

    private static String getTotalTime(List<String> shortestDistanceStations) {

        return SectionRepository.findTotalDistance(shortestDistanceStations);
    }
}
