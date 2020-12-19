package subway.views.routeviews;

import subway.domain.MainMenu;
import subway.views.OutputView;

import java.util.Arrays;

public class RouteOutputView implements OutputView {
    private static final String ROUTE_SCREEN_MESSAGE = "## 경로 기준";

    public static void printRouteMenu() {
        System.out.println(LINE_WRAP + ROUTE_SCREEN_MESSAGE);
        Arrays.stream(MainMenu.values())
            .forEach(System.out::println);
    }
}
