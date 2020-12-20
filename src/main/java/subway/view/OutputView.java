package subway.view;

import subway.dto.ShortestPathDto;

import java.util.List;

public class OutputView {
    private static final String TITLE_PREFIX = "## ";
    private static final String MAIN_SCREEN_TITLE = "메인 화면";
    private static final String PATH_SCREEN_TITLE = "경로 기준";
    private static final String RESULT_TITLE = "조회 결과";
    private static final String LINE = "---";
    private static final String INFO_MESSAGE_PREFIX = "[INFO] ";
    private static final String TOTAL_DISTANCE_MESSAGE_PREFIX = "총 거리: ";
    private static final String TOTAL_TIME_MESSAGE_PREFIX = "총 소요 시간: ";
    private static final String KM = "km";
    private static final String MINUTE = "분";


    public static void printMainScreen(String commandTypeInfos) {
        printTitle(MAIN_SCREEN_TITLE);
        System.out.println(commandTypeInfos);
    }

    public static void printPathScreen(String searchTypeInfos) {
        printTitle(PATH_SCREEN_TITLE);
        System.out.println(searchTypeInfos);
    }

    public static void printResult(ShortestPathDto shortestPathDto) {
        int totalDistance = shortestPathDto.getKm();
        int totalTime = shortestPathDto.getMinute();
        List<String> stations = shortestPathDto.getStations();

        printTitle(RESULT_TITLE);
        printInfo(LINE);
        printTotalDistance(totalDistance);
        printTotalTime(totalTime);
        printInfo(LINE);
        printPath(stations);
        lineFeed();
    }

    private static void printTotalDistance(int totalDistance) {
        printInfo(TOTAL_DISTANCE_MESSAGE_PREFIX + totalDistance + KM);
    }

    private static void printTotalTime(int totalTime) {
        printInfo(TOTAL_TIME_MESSAGE_PREFIX + totalTime + MINUTE);
    }

    private static void printPath(List<String> stations) {
        stations.stream()
                .forEach(OutputView::printInfo);
    }

    private static void printTitle(String title) {
        System.out.println(TITLE_PREFIX + title);
    }

    private static void printInfo(int message) {
        System.out.println(INFO_MESSAGE_PREFIX + message);
    }

    private static void printInfo(String message) {
        System.out.println(INFO_MESSAGE_PREFIX + message);
    }

    private static void lineFeed() {
        System.out.println();
    }
}
