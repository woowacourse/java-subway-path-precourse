package subway.controller;

import subway.domain.Criterions;
import subway.domain.Menus;
import subway.view.InputView;
import subway.view.OutputView;

public class MenuController {

    private static final Menus menus = new Menus();
    private static final Criterions criterions = new Criterions();

    public MenuController() {
    }

    public String scanMainMenu(InputView inputView) {
        OutputView.printMainScreen();
        String selectedMenu;
        do {
            selectedMenu = inputView.scanMenu();
        } while(!menus.isValid(selectedMenu));
        return selectedMenu;
    }

    public String scanCriterions(InputView inputView) {
        OutputView.printSubScreen();
        String selectedCriterion;
        do {
            selectedCriterion = inputView.scanMenu();
        } while(!criterions.isValid(selectedCriterion));
        return selectedCriterion;
    }
}
