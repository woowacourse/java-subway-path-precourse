package subway.view;

import java.util.List;
import subway.domain.section.ResultDto;
import subway.domain.station.Station;
import subway.screen.Screen;

public class OutputView {

    private static final String INFO_PREFIX = "[INFO] ";
    private static final String PREFIX = "## ";
    private static final String BOUNDARY_LINE = INFO_PREFIX + "---";
    private static final String TOTAL_DISTANCE_MESSAGE = "총 거리: ";
    private static final String TOTAL_TIME_MESSAGE = "총 소요 시간: ";
    private static final String SEARCH_RESULT_MESSAGE = INFO_PREFIX + "조회 결과";

    public static void printResult(final List<Station> stations, ResultDto resultDto) {
        System.out.println(SEARCH_RESULT_MESSAGE);
        System.out.println(BOUNDARY_LINE);
        printDistanceAndTime(resultDto);
        printStations(stations);
        System.out.println();
    }

    private static void printStations(List<Station> stations) {
        for (Station station : stations) {
            printWithPrefix(station.toString());
        }
    }

    private static void printDistanceAndTime(final ResultDto resultDto) {
        printWithPrefix(TOTAL_DISTANCE_MESSAGE + getDistanceString(resultDto));
        printWithPrefix(TOTAL_TIME_MESSAGE + getTimeString(resultDto));
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    private static void printWithPrefix(String message) {
        System.out.println(INFO_PREFIX + message);
    }

    private static String getTimeString(ResultDto resultDto) {
        return resultDto.getResultTime().toString();
    }

    private static String getDistanceString(ResultDto resultDto) {
        return resultDto.getResultDistance().toString();
    }


    public static void printMenus(Screen currentScreen) {
        System.out.println(PREFIX + currentScreen.getTitle());
        for (Screen screen : currentScreen.getValues()) {
            System.out.println(screen.toString());
        }
        System.out.println();
    }
}
