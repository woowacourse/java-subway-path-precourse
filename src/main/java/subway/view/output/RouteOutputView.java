package subway.view.output;

import java.util.List;

public class RouteOutputView extends OutputView {
    private static String ROUTE_VIEW = "경로 기준\n";

    public void printRouteMenu(List<String> list) {
        printMenu(ROUTE_VIEW, list);
    }
}
