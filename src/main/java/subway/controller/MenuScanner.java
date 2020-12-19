package subway.controller;

import subway.domain.Criterions;
import subway.domain.Functions;
import subway.domain.Menus;
import subway.view.InputView;
import subway.view.OutputView;

public class MenuScanner {

    private static final Functions functions = new Functions();
    private static final Criterions criterions = new Criterions();

    public MenuScanner() {
    }

    public String scanMenus(InputView inputView) {
        String selectedFunction = scanFunctions(inputView);
        boolean quit = Menus.isQuit(selectedFunction);
        if (quit) {
            return selectedFunction;
        }
        String selectedCriterion = scanCriterions(inputView);
        return selectedCriterion;
    }

    public String scanFunctions(InputView inputView) {
        OutputView.printMainScreen();
        String selectedFunction;
        do {
            selectedFunction = inputView.scanMenu();
        } while(!functions.isValid(selectedFunction));
        return selectedFunction;
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
