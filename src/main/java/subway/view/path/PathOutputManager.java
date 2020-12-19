package subway.view.path;

import java.util.List;
import subway.common.GuideMessage;
import subway.common.InfoMessage;
import subway.domain.PathRepository;

public class PathOutputManager {
    private static final String ENTER_DEPARTURE_STATION = "출발역을 입력하세요.";
    private static final String ENTER_ARRIVAL_STATION = "도착역을 입력하세요.";
    private static final String DIVIDER = "---";
    private static final String TOTAL_DISTANCE = "총 거리 : ";
    private static final String KM = "km";
    private static final String RESULT = "조회 결과";
    private static final String TOTAL_TIME = "총 소요 시간 : ";
    private static final String MINUTE = "분";


    public static void printDepartureStationGuide() {
        GuideMessage.print(ENTER_DEPARTURE_STATION);
    }

    public static void printArrivalStationGuide() {
        GuideMessage.print(ENTER_ARRIVAL_STATION);
    }

    public static void printResult(List<String> path) {
        GuideMessage.print(RESULT);
        InfoMessage.print(DIVIDER);
        InfoMessage.print(TOTAL_DISTANCE + PathRepository.getDistanceByList(path) + KM);
        InfoMessage.print(TOTAL_TIME + PathRepository.getTimeByList(path) + MINUTE);
        InfoMessage.print(DIVIDER);
        path.forEach(InfoMessage::print);
    }
}
