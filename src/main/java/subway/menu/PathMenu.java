package subway.menu;

import subway.service.DistancePathService;
import subway.service.TimePathService;

import java.util.Arrays;

public enum PathMenu {
    DISTANCE("1","1. 최단 거리", DistancePathService::serviceStart),
    TIME("2", "2. 최소 시간", TimePathService::serviceStart),
    BACK("B","B. 돌아가기", null);

    private final String option;
    private final String message;
    private final Runnable expression;

    PathMenu(String option, String message, Runnable expression) {
        this.option = option;
        this.message = message;
        this.expression = expression;
    }

    public void request() {
        expression.run();
    }

    public static PathMenu findPathMenuByOption(String option) {
        return Arrays.stream(values())
                .filter(value -> value.getOption().equals(option))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public String getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }
}
