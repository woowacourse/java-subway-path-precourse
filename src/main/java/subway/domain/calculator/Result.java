package subway.domain.calculator;

import java.util.List;

public class Result {
    private final List<String> route;
    private int distance;
    private int time;

    public Result(List<String> route) {
        this.route = route;
    }

    public List<String> getRoute() {
        return route;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
