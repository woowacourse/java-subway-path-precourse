package subway.views;

import subway.domain.MainMenu;

import java.util.Arrays;

public class MainOutputView {
    private static final String MAIN_SCREEN_MESSAGE = "## 메인 화면";

    public static void printMainView() {
        System.out.println(MAIN_SCREEN_MESSAGE);
        Arrays.stream(MainMenu.values())
            .forEach(System.out::println);
    }
}
