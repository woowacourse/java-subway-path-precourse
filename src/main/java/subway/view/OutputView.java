package subway.view;

import subway.menuSelection.MainMenuSelection;
import subway.menuSelection.PathStandardSelection;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String SHARP_PREFIX = "## ";
    private static final String MAIN_SCREEN = "메인 화면";
    private static final String PATH_STANDARD = "경로 기준";

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void printMainMenu() {
        System.out.println(SHARP_PREFIX + MAIN_SCREEN);
        for (MainMenuSelection menu : MainMenuSelection.values()) {
            System.out.println(menu);
        }
    }

    public static void printPathStandardSelectionMenu() {
        System.out.println(SHARP_PREFIX + PATH_STANDARD);
        for (PathStandardSelection menu : PathStandardSelection.values()) {
            System.out.println(menu);
        }
    }
}
