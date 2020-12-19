package subway.domain;

import java.util.Arrays;

public enum RouteCheckType {
    SHORTEST_DISTANCE("1"),
    MINIMUM_TIME("2"),
    BACK("B");

    private static final String MENU_ERROR = "[ERROR] 선택할 수 없습니다.";

    private String text;

    RouteCheckType(String text) {
        this.text = text;
    }

    public static RouteCheckType of(String input) {
        return Arrays.stream(RouteCheckType.values())
                .filter(menu -> menu.text.equals(input.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MENU_ERROR));
    }
}
