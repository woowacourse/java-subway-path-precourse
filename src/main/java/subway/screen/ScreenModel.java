package subway.screen;

public interface ScreenModel {
    public default String showScreen() {return "-1";}
    public default ScreenModel getNextScreen(String input) {return null;}
}
