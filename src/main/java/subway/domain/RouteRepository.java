package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class RouteRepository {
    private static final List<Route> routes = new ArrayList<>();

    public static void addRoute(Route route) {
        routes.add(route);
    }
}
