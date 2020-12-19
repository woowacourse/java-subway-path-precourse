package subway.controller;

import subway.domain.Criterions;
import subway.domain.Functions;
import subway.domain.exception.NonExistentMenuException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class MenuScanner {

    private static final Functions functions = new Functions();
    private static final Criterions criterions = new Criterions();
    private static final List<String> signs = Arrays.asList(new String[]{});

    public MenuScanner() {
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
