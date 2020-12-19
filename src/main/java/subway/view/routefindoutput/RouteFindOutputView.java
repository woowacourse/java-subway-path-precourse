package subway.view.routefindoutput;

import subway.view.OutputView;

public class RouteFindOutputView extends OutputView {
    private static final String ROUTE_FIND_CONTROLLER_OPTION = "경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";

    public static void printOption () {
        printOutput(ROUTE_FIND_CONTROLLER_OPTION);
        printNewLine();
    }
}
