package subway.view;

import subway.menu.MainMenu;

import java.util.Arrays;

public class OutputView {
    private static final String MAIN_HEADER = "## 메인 화면";

    public static void printMainMenu() {
        System.out.println(MAIN_HEADER);
        Arrays.stream(MainMenu.values())
                .map(MainMenu::getMessage)
                .forEach(System.out::println);
    }
}
