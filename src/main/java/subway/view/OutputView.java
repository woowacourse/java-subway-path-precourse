package subway.view;

import subway.menuSelection.MainMenuSelection;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String SHARP_PREFIX = "## ";
    private static final String MAIN_SCREEN = "메인 화면";

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void printMainMenu() {
        System.out.println(SHARP_PREFIX + MAIN_SCREEN);
        for (MainMenuSelection menu : MainMenuSelection.values()) {
            System.out.println(menu);
        }
    }
}
