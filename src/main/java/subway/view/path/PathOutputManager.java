package subway.view.path;

import subway.common.GuideMessage;

public class PathOutputManager {
    private static final String ENTER_DEPARTURE_STATION = "출발역을 입력하세요.";
    private static final String ENTER_ARRIVAL_STATION = "도착역을 입력하세요.";

    public static void printDepartureStationGuide(){
        GuideMessage.print(ENTER_DEPARTURE_STATION);
    }

    public static void printArrivalStationGuide(){
        GuideMessage.print(ENTER_ARRIVAL_STATION);
    }
}
