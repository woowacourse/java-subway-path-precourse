package subway.view;

import java.util.Scanner;

import subway.menu.MainMenu;
import subway.menu.NotAccptedMenuInputException;
import subway.menu.SubMenu;

public class InputView {
    private static final String INPUT_FUNCTION_MESSAGE = "\n## 원하는 기능을 선택하세요.";
    private static final boolean IS_MAIN_MENU = true;
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputMainMenu() {
        String menuNumber = "";
        try {
            menuNumber = scanWithInputMessage(IS_MAIN_MENU);
        } catch (NotAccptedMenuInputException e) {
            OutputView.printErrorMessage(e);
            inputMainMenu();
        }
        return menuNumber;
    }

    public String inputSubMenu() {
        String menuNumber = "";
        try {
            menuNumber = scanWithInputMessage(!IS_MAIN_MENU);
        } catch (NotAccptedMenuInputException e) {
            OutputView.printErrorMessage(e);
            inputMainMenu();
        }
        return menuNumber;
    }

    private String scanWithInputMessage(boolean isMainMenu) {
        System.out.println(INPUT_FUNCTION_MESSAGE);

        if (isMainMenu) {
            return isAccptedMainMenuInput(scanner.nextLine());
        }
        return isAccptedSubMenuInput(scanner.nextLine());
    }

    private String isAccptedMainMenuInput(String menu) {
        if (menu.equals(MainMenu.PATH_VIEW_SEL) || menu.equals(MainMenu.QUIT_MENU_SEL)) {
            return menu;
        }
        throw new NotAccptedMenuInputException();
    }

    private String isAccptedSubMenuInput(String menu) {
        if (menu.equals(SubMenu.SHORTEST_PATH) || menu.equals(SubMenu.MINIMUM_TIME)
                || menu.equals(SubMenu.BACK_MENU_SEL)) {
            return menu;
        }
        throw new NotAccptedMenuInputException();
    }
}
