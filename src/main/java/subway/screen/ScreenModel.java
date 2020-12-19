package subway.screen;

public interface ScreenModel {
    public default String showMenu() {return null;}
    public default ScreenModel getNextMenuScreen(String input) {return null;}
    public default void apply() {}
}
