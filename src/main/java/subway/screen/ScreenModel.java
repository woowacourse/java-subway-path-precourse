package subway.screen;

public interface ScreenModel {
    public static final String DONE = "-1";
    public static final ScreenModel NOTHING = null;

    public default String showScreen() {
        return DONE;
    }

    public default ScreenModel getNextScreen(String input) {
        return NOTHING;
    }
}
