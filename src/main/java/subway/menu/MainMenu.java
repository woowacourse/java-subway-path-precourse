package subway.menu;

import subway.view.InputView;
import subway.view.OutputView;

public class MainMenu {
    public static final String PATH_VIEW_SEL = "1";
    public static final String QUIT_MENU_SEL = "Q";
    private InputView inputView;

    public MainMenu(InputView inputView) {
        this.inputView = inputView;
    }

    private void printMainMenu() {
        OutputView.printMainDisplay();
    }

    private String inputMainMenu() {
        return inputView.inputMainMenu();
    }

    public void runMainMenu() {
        printMainMenu();
        String selMenu = inputMainMenu();

        if (selMenu.equals(PATH_VIEW_SEL)) {

        }

        if (selMenu.equals(QUIT_MENU_SEL)) {

        }
    }
}
