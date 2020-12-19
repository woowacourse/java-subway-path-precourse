package subway.view;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MainDisplay extends Display {

    private static final String DISPLAY_NAME = "메인 화면";
    private static final String MENU_DOT = ". ";

    public static void loadMenu() {
        MainMenu selectedMenu = null;
        while (selectedMenu != MainMenu.QUIT) {
            printMenu();
            selectedMenu = selectMenu();
            selectedMenu.execute();
        }
    }

    private static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(MainMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + MENU_DOT + menu.getName()));
    }

    private static MainMenu selectMenu() {
        while (true) {
            try {
                return MainMenu.getMenuByInput(UserInput.getSelectMenu());
            } catch (NoSuchElementException e) {
                printMenuSelectError();
            }
        }
    }

}
