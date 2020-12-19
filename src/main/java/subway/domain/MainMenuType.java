package subway.domain;

import java.util.Arrays;

public enum MainMenuType {

    ROUTE_CHECK("1"),
    END_PROGRAM("Q");


    private static final String MENU_ERROR = "[ERROR] 선택할 수 없습니다.";

    private String text;

    MainMenuType(String text) {
        this.text = text;
    }

    public static MainMenuType of(String input) {
        return Arrays.stream(MainMenuType.values())
                .filter(menu -> menu.text.equals(input.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MENU_ERROR));
    }
}
