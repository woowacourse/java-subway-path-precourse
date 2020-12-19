package subway.controller;

import subway.domain.Criterions;
import subway.domain.Menus;
import subway.domain.exception.NonExistentMenuException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class MenuController {

    private static final Menus menus = new Menus();
    private static final Criterions criterions = new Criterions();
    private static final List<String> signs = Arrays.asList(new String[]{});

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

    public boolean isValid(String sign) {
        try {
            checkValidationOf(sign);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private void checkValidationOf(String sign) {
        if (!isInSignList(sign)) {
            throw new NonExistentMenuException();
        }
    }

    private boolean isInSignList(String sign) {
        if (signs.contains(sign)) {
            return true;
        }
        return false;
    }
}
