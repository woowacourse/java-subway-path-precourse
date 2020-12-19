package subway.view;

import subway.enums.info.MainInfo;
import subway.enums.menu.MainMenu;

import java.util.Arrays;
import java.util.List;

public class MainView {
    public static void printMainMenu() {
        System.out.println();
        MainMenu[] mainMenu = MainMenu.values();
        List<MainMenu> menu = Arrays.asList(mainMenu);
        menu.stream().map(MainMenu::getMenu).forEach(System.out::println);
        System.out.println();
    }

    public static void askInputMenu() {
        System.out.println(MainInfo.INPUT.getInfo());
    }
}
