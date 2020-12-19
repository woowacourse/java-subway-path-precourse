package subway.view;

import java.util.Scanner;

import subway.menu.MainMenu;
import subway.menu.NotAccptedMenuInputException;

public class InputView {
    private static final String INPUT_FUNCTION_MESSAGE = "\n## 원하는 기능을 선택하세요.";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputMainMenu() {
        String menuNumber = "";
        try {
            menuNumber = scanWithInputMessage();
        } catch(NotAccptedMenuInputException e) {
            OutputView.printErrorMessage(e);
            inputMainMenu();
        }
        return menuNumber;
    }
    
    private String scanWithInputMessage() {
        System.out.println(INPUT_FUNCTION_MESSAGE);
        return isAccptedMainMenuInput(scanner.nextLine());
    }
    
    private String isAccptedMainMenuInput(String menu) {
        if (menu.equals(MainMenu.PATH_VIEW_SEL) || menu.equals(MainMenu.QUIT_MENU_SEL)) {
            return menu;
        }
        throw new NotAccptedMenuInputException();
    }
}
