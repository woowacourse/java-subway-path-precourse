package subway.view.routefindoutput;

import subway.view.ErrorView;

public class RouteFindErrorView extends ErrorView {
    private static final String ERROR_SAME_STATION_INPUT = "출발역과 도착역이 동일합니다.";
    private static final String ERROR_NOT_IN_STATION_REPOSITORY = "등록된 역이 아닙니다.";
    private static final String ERROR_PATH_NOT_CONNECTED = "연결된 경로가 없습니다.";

    public static void printSameStationInputError() {
        printError(ERROR_SAME_STATION_INPUT);
    }

    public static void printNotInStationRepositoryError() {
        printError(ERROR_NOT_IN_STATION_REPOSITORY);
    }

    public static void printPathNotConnectedError() {
        printError(ERROR_PATH_NOT_CONNECTED);
    }
}
