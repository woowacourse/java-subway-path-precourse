package subway.domain;

import subway.domain.exception.NonExistentMenuException;;

import java.util.Arrays;
import java.util.List;

public class Criterions {

    private static final String distanceSign = "1";
    private static final String timeSign = "2";
    private static final String backSign = "B";
    private static final List<String> signs = Arrays
        .asList(new String[]{distanceSign, timeSign, backSign});

    public Criterions() {
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
