package subway.domain;

import subway.domain.exception.NonExistentMenuException;
import subway.view.InputView;

import java.util.Arrays;
import java.util.List;

public abstract class Menus {

    public static final Functions functions = new Functions();
    public static final Criterions criterions = new Criterions();
    private static final List<String> signs = Arrays.asList(new String[]{});

    public static void run(InputView inputView, String selectedCriterions) {
        if (isBack(selectedCriterions)) {
            return;
        }
        String start = inputView.scanStartStation();
        String end = inputView.scanEndStation();
        search(start, end);
    }

    public static void search(String start, String end) {

    }

    public static boolean isQuit(String sign) {
        return functions.isQuit(sign);
    }

    public static boolean isBack(String sign) {
        return criterions.isBack(sign);
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
        if (getSigns().contains(sign)) {
            return true;
        }
        return false;
    }

    public List<String> getSigns() {
        return signs;
    }
}
