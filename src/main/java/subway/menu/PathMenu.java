package subway.menu;

import java.util.Arrays;

public enum PathMenu {
    DISTANCE("1","1. 최단 거리"),
    TIME("2", "2. 최소 시간"),
    BACK("B","B. 돌아가기");

    private final String option;
    private final String message;

    PathMenu(String option, String message) {
        this.option = option;
        this.message = message;
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
