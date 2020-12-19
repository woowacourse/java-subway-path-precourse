package subway.domain.calculator;

import java.util.List;

public class Result {
    private final List<String> route;
    private int distance;
    private int time;

    public Result(List<String> route) {
        this.route = route;
    }
}
