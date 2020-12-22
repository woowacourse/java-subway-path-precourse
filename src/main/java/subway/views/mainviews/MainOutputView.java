package subway.views.mainviews;

import subway.menus.MainMenu;
import subway.views.OutputView;

import java.util.Arrays;

public class MainOutputView implements OutputView {
    private static final String MAIN_SCREEN_MESSAGE = "## 메인 화면";

    private MainOutputView() {
    }

    public static void printMainMenu() {
        System.out.println(MAIN_SCREEN_MESSAGE);
        Arrays.stream(MainMenu.values())
            .forEach(System.out::println);
    }
}
