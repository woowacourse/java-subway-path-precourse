package subway.view;

import subway.type.ScreenType;
import subway.type.TextType;

public class OutputView {
    public static void printMainScreen() {
        System.out.println(ScreenType.MAIN_SCREEN.getScreen()
                + ScreenType.PATH_SHOW.getScreen()
                + ScreenType.QUITTING.getScreen()
                + ScreenType.OPTION_CHOICE.getScreen());
    }

    public static void printPathCriteriaScreen() {
        System.out.println(ScreenType.PATH_CRITERIA_SCREEN.getScreen()
                + ScreenType.SHORTEST_DISTANCE.getScreen()
                + ScreenType.SHORTEST_TIME.getScreen()
                + ScreenType.BACK.getScreen()
                + ScreenType.OPTION_CHOICE.getScreen());
    }

    public static void printOriginText() {
        System.out.println(TextType.ORIGIN_TEXT.getText());
    }

    public static void printDestinationText() {
        System.out.println(TextType.DESTINATION_TEXT.getText());
    }
}
