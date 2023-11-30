package subway.domain;

import java.util.Collections;
import java.util.List;

public class Result {
    private final int totalDistance;
    private final int totalTime;
    private final List<String> routes;

    private Result(int totalDistance, int totalTime, List<String> routes) {
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.routes = routes;
    }

    public static Result createResult(int totalDistance, int totalTime, List<String> routes) {
        return new Result(totalDistance, totalTime, routes);
    }

    public List<String> getRoutes() {
        return Collections.unmodifiableList(routes);
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }
}
