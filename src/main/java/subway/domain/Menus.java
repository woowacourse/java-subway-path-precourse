package subway.domain;

import java.util.Arrays;
import java.util.List;
import subway.domain.exception.NonExistentMenuException;

public abstract class Menus {

    public static final Functions functions = new Functions();
    public static final Criterions criterions = new Criterions();
    private static final List<String> signs = Arrays.asList(new String[]{});

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
