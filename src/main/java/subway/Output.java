package subway;

import java.util.List;

public class Output {

    private static final String MAIN_VIEW = "## 메인 화면";
    private static final String ROUTE_SEARCH = "1. 경로 조회";
    private static final String QUIT = "Q. 종료";
    private static final String[] MAIN_LIST = {MAIN_VIEW, ROUTE_SEARCH, QUIT};
    private static final String ERROR = "[ERROR] ";
    private static final String INFO = "[INFO] ";
    private static final String BAD_CHOICE = "목록에 없는것을 선택하셨습니다.\n";
    private static final String ROUTE_VIEW = "## 경로 기준";
    private static final String MIN_DISTANCE = "1. 최단 거리";
    private static final String SHORT_TIME = "2. 최소 시간";
    private static final String BACK = "B. 돌아가기";
    private static final String[] ROUTE_LIST = {ROUTE_VIEW, MIN_DISTANCE, SHORT_TIME, BACK};
    private static final String SEARCH_RESULT = "## 조회 결과";
    private static final String THREE_MANUS = "---";
    private static final String TOTAL_DISTANCE = "총 거리: ";
    private static final String KM = "km";
    private static final String TOTAL_TIME = "총 소요 시간: ";
    private static final String MINUTE = "분";
    private static final String STATION_EQUALS_ERROR = "출발역과 도착역이 동일합니다.\n";
    public static final String YOU_CHOICE = "## 원하는 기능을 선택하세요";
    public static final String START_STATION = "## 출발역을 입력하세요.";
    public static final String END_STATION = "## 도착역을 입력하세요.";


    private static void printView(String[] strArray) {
        for (String str : strArray) {
            System.out.println(str);
        }
        System.out.println();
    }

    public static void printMainView() {
        printView(MAIN_LIST);
    }

    public static void printChoiceErrorMessage() {
        System.out.println(ERROR + BAD_CHOICE);
    }

    public static void printRouteSearchView() {
        printView(ROUTE_LIST);
    }

    public static void printInputBefore(String str) {
        System.out.println(str);
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printInfo(int distance, int time, List<String> path) {
        System.out.println(INFO + SEARCH_RESULT);
        System.out.println(INFO + THREE_MANUS);
        System.out.println(INFO + TOTAL_DISTANCE + distance + KM);
        System.out.println(INFO + TOTAL_TIME + time + MINUTE);
        System.out.println(INFO + THREE_MANUS);
        for (String station : path) {
            System.out.println(INFO + station);
        }
        System.out.println();
    }

    public static void printStationEqualsError() {
        System.out.println(STATION_EQUALS_ERROR);
    }
}
