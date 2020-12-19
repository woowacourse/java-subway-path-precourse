package subway.view;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class PathFindDisplay extends Display {

    private static final String DISPLAY_NAME = "경로 기준";
    private static final String MENU_DOT = ". ";

    public static void loadMenu() {
        PathFindMenu selectedMenu = null;
        while (selectedMenu != PathFindMenu.BACK) {
            printMenu();
            selectedMenu = selectMenu();
            try{
                selectedMenu.execute();
                break;
            } catch (IllegalArgumentException e){
                printError(e.getMessage());
            }
        }
    }

    private static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(PathFindMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + MENU_DOT + menu.getName()));
    }

    private static PathFindMenu selectMenu() {
        while (true) {
            try {
                return PathFindMenu.getMenuByInput(UserInput.getSelectMenu());
            } catch (NoSuchElementException e) {
                printMenuSelectError();
            }
        }
    }
}
