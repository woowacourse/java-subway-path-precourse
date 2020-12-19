package subway.view.output;

import java.util.List;

public class RouteOutputView extends OutputView {
    private static String ROUTE_VIEW = "경로 기준\n";
    private static String INPUT_FIRST_STATION = "출발역을 입력하세요.\n";
    private static String INPUT_LAST_STATION = "도착역을 입력하세요\n";

    public void printRouteMenu(List<String> list) {
        printMenu(ROUTE_VIEW, list);
    }

    public void printFirstStation() {
        menuSymbol();
        stringBuilder.append(INPUT_FIRST_STATION);
        print();
    }

    public void printLastStation() {
        menuSymbol();
        stringBuilder.append(INPUT_LAST_STATION);
        print();
    }
}
