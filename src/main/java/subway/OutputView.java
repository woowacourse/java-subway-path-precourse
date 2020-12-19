package subway;

import subway.domain.Station;

public class OutputView {
    public static final String MAIN_HEADER = "## 메인 화면";
    public static final String MAIN_OPTIONS = "1. 경로 조회, \nQ.종료";
    public static final String ROUTE_SEARCH_HEADER = "## 경로 기준";
    public static final String ROUTE_SEARCH_OPTIONS = "1. 최단 거리\n2. 최소 시간\nB. 돌아가기";
    public static final String CHOOSE_OPTIONS = "## 원하는 기능을 선택하세요.";
    public static final String INPUT_START_STATION = "## 출발역을 입력하세요.";
    public static final String INPUT_END_STATION = "## 도착역을 입력하세요.";
    public static final String SEARCH_RESULT_HEADER = "## 조회 결과";

    private OutputView() {
    }
    public static void printMainView() {
        System.out.println(MAIN_HEADER);
        System.out.println(MAIN_OPTIONS);
        System.out.println(CHOOSE_OPTIONS);
    }

    public static void printRouteSearchView() {
        System.out.println(ROUTE_SEARCH_HEADER);
        System.out.println(ROUTE_SEARCH_OPTIONS);
        System.out.println(CHOOSE_OPTIONS);
    }

    public static void printStartStationMessage() {
        System.out.println(INPUT_START_STATION);
    }

    public static void printEndStationMessage() {
        System.out.println(INPUT_END_STATION);
    }

    public static void printSearchResult(Station start,Station end){
        System.out.println(SEARCH_RESULT_HEADER);
    }
}
