package subway.menu;

import subway.view.InputView;
import subway.view.OutputView;

public class MainMenu implements Menu {
    public static final String PATH_VIEW_SEL = "1";
    public static final String QUIT_MENU_SEL = "Q";
    private InputView inputView;
    private SubMenu subMenu;

    public MainMenu(InputView inputView) {
        this.inputView = inputView;
        subMenu = new SubMenu(inputView);
    }

    @Override
    public void printMenu() {
        OutputView.printMainDisplay();
    }

    @Override
    public String inputMenu() {
        return inputView.inputMainMenu();
    }

    @Override
    public void runMenu() {
        printMenu();
        String selMenu = inputMenu();

        if (selMenu.equals(PATH_VIEW_SEL)) {
            subMenu.runMenu();
        }

        if (selMenu.equals(QUIT_MENU_SEL)) {
            System.exit(0);
        }
    }
}
