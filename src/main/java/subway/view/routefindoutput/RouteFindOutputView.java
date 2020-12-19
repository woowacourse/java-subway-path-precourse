package subway.view.routefindoutput;

import subway.view.OutputView;

public class RouteFindOutputView extends OutputView {
    private static final String ROUTE_FIND_CONTROLLER_OPTION = "경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";

    private static final String ENTER_START_STATION = "출발역을 입력하세요.";
    private static final String ENTER_END_STATION = "도착역을 입력하세요.";

    private static final String PATH_RESULT = "조회 결과";

    public static void printOption () {
        printOutput(ROUTE_FIND_CONTROLLER_OPTION);
        printNewLine();
    }

    public static void printStartStationInstruction() {
        printOutput(ENTER_START_STATION);
    }

    public static void printEndStationInstruction() {
        printOutput(ENTER_END_STATION);
    }

    public static void printPathResult() {
        printOutput(PATH_RESULT);
    }
}
