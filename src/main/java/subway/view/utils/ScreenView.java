package subway.view.utils;

import subway.type.ScreenType;

public class ScreenView {
    public static void printMainScreen() {
        System.out.println(ScreenType.MAIN_SCREEN.getScreen()
                + ScreenType.PATH_SHOW.getScreen()
                + ScreenType.QUITTING.getScreen());
    }

    public static void printPathCriteriaScreen() {
        System.out.println(ScreenType.PATH_CRITERIA_SCREEN.getScreen()
                + ScreenType.SHORTEST_DISTANCE.getScreen()
                + ScreenType.SHORTEST_TIME.getScreen()
                + ScreenType.BACK.getScreen());
    }
}
