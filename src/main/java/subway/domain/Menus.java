package subway.domain;

import java.util.Arrays;
import java.util.List;
import subway.domain.exception.NonExistentMenuException;

public class Menus {

    private static final String searchSign = "1";
    private static final String quitSign = "Q";
    private static final List<String> signs = Arrays
        .asList(new String[]{searchSign, quitSign});

    public Menus() {
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
