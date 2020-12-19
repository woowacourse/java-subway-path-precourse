package subway.menu;

import subway.domain.PathSelectMapper;

import java.util.Arrays;

public enum MainMenu {
    PATH_SERVICE("1","1. 경로 조회", PathSelectMapper::run),
    EXIT("Q", "Q. 종료", null);

    private final String option;
    private final String message;
    private final Runnable expression;

    MainMenu(String option, String message, Runnable expression) {
        this.option = option;
        this.message = message;
        this.expression = expression;
    }

    public void request() {
        expression.run();
    }

    public static MainMenu findMainMenuByOption(String option) {
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
