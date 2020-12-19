package subway.view;

import subway.menu.MainMenu;
import subway.menu.PathMenu;

import java.util.Arrays;

public class OutputView {
    private static final String MAIN_HEADER = "## 메인 화면";
    private static final String PATH_HEADER = "## 경로 기준";

    public static void printMainMenu() {
        System.out.println(MAIN_HEADER);
        Arrays.stream(MainMenu.values())
                .map(MainMenu::getMessage)
                .forEach(System.out::println);
    }

    public static void printPathMenu() {
        System.out.println(PATH_HEADER);
        Arrays.stream(PathMenu.values())
                .map(PathMenu::getMessage)
                .forEach(System.out::println);
    }
}
