package subway.pathfind.printer.error;

import subway.common.CommonPrinter;

public class PathFindErrorPrinter {
    private static final String NOT_EXISTS_STATION_ERROR_MESSAGE
        = "\n" + CommonPrinter.ERROR_PREFIX + "존재하지 않는 역입니다.";
    private static final String START_END_STATION_EQUAL_ERROR_MESSAGE
        = "\n" + CommonPrinter.ERROR_PREFIX + "출발역과 도착역이 동일합니다.";

    public static void printNotExistsStationErrorMessage() {
        System.out.println(NOT_EXISTS_STATION_ERROR_MESSAGE);
    }

    public static void printStartEndStationEqualErrorMessage() {
        System.out.println(START_END_STATION_EQUAL_ERROR_MESSAGE);
    }
}
