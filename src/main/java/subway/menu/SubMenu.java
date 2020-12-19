package subway.menu;

import subway.view.InputView;
import subway.view.OutputView;

public class SubMenu implements Menu {
    public static final String SHORTEST_PATH = "1";
    public static final String MINIMUM_TIME = "2";
    public static final String BACK_MENU_SEL = "B";
    private InputView inputView;

    public SubMenu(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void printMenu() {
        OutputView.printSubDisplay();
    }

    @Override
    public String inputMenu() {
        return inputView.inputSubMenu();
    }

    @Override
    public void runMenu() {
        printMenu();
        String selMenu = inputMenu();

        if (selMenu.equals(BACK_MENU_SEL)) {
            return;
        }
    }
}
