package subway.screen;

import subway.Menu.Menu;

import java.util.Arrays;

public interface ScreenModel {
    public static final String GO_MAIN = "0";
    public static final String GO_BACK = "-1";
    public static final ScreenModel NOTHING = null;

    public default String showScreen() {
        return GO_BACK;
    }

    public default ScreenModel getNextScreen(String input) {
        return NOTHING;
    }

    public default boolean anyMatchToMenu(String input) {
        return false;
    }
}
