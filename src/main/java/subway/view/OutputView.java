package subway.view;

import java.util.List;

public class OutputView {

    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String MAIN_OPTION_INQUIRY = "1. 경로 조회";
    private static final String MAIN_OPTION_EXIT = "Q. 종료";

    private static final String INQUIRY_TITLE = "## 경로 기준";
    private static final String INQUIRY_SHORTEST_PATH = "1. 최단 거리";
    private static final String INQUIRY_LEAST_TIME = "2. 최소 시간";
    private static final String INQUIRY_BACK = "B. 돌아가기";

    private static final String RESULT_TITLE = "## 조회 결과";
    private static final String RESULT_LINE = "---";
    private static final String RESULT_DISTANCE_FORMAT = "총 거리: %dkm";
    private static final String RESULT_TIME_FORMAT = "총 소요 시간: %d분";

    private static final String QUERY_FUNCTION_SELECT = "## 원하는 기능을 선택하세요.";
    private static final String QUERY_SOURCE_STATION = "## 출발역을 입력하세요.";
    private static final String QUERY_DESTINATION_STATION = "## 도착역을 입력하세요.";

    private static final String TRY_AGAIN = " 다시 입력해주세요.";
    public static final String ERROR_INVALID_SELECT = "선택할 수 없는 기능입니다." + TRY_AGAIN;
    public static final String ERROR_INVALID_STATION = "존재하지 않는 역입니다." + TRY_AGAIN;
    public static final String ERROR_SAME_STATION = "출발역과 도착역이 동일합니다." + TRY_AGAIN;
    public static final String ERROR_UNREACHABLE = "죄송합니다. 두 역은 연결되어 있지 않습니다.";

    public static void printMain() {
        System.out.println(MAIN_TITLE);
        System.out.println(MAIN_OPTION_INQUIRY);
        System.out.println(MAIN_OPTION_EXIT);
        printEmptyLine();
    }

    public static void printInquiry() {
        System.out.println(INQUIRY_TITLE);
        System.out.println(INQUIRY_SHORTEST_PATH);
        System.out.println(INQUIRY_LEAST_TIME);
        System.out.println(INQUIRY_BACK);
        printEmptyLine();
    }

    public static void printFunctionSelectQuery() {
        System.out.println(QUERY_FUNCTION_SELECT);
    }

    public static void printSourceStationQuery() {
        System.out.println(QUERY_SOURCE_STATION);
    }

    public static void printDestinationStationQuery() {
        System.out.println(QUERY_DESTINATION_STATION);
    }

    public static void printInquiryGraph(final List<String> graph, final int totalDistance, final int totalTime) {
        System.out.println(RESULT_TITLE);
        printInformation(RESULT_LINE);
        printInformation(String.format(RESULT_DISTANCE_FORMAT, totalDistance));
        printInformation(String.format(RESULT_TIME_FORMAT, totalTime));
        printInformation(RESULT_LINE);
        for (String stationName : graph) {
            printInformation(stationName);
        }
        printEmptyLine();
    }

    public static void printInformation(final String message) {
        System.out.println("[INFO] " + message);
    }

    public static void printError(final String message) {
        System.out.println("[ERROR] " + message);
        printEmptyLine();
    }

    public static void printEmptyLine() {
        System.out.println();
    }

}
