package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Criterions extends Menus {

    private static final String distanceSign = "1";
    private static final String timeSign = "2";
    private static final String backSign = "B";
    private static final List<String> signs = Arrays
        .asList(new String[]{distanceSign, timeSign, backSign});

    public Criterions() {
    }

    @Override
    public List<String> getSigns() {
        return signs;
    }

    public static boolean isBack(String sign) {
        if (sign.equals(backSign)) {
            return true;
        }
        return false;
    }

    public boolean isDistanceSign(String sign) {
        if (sign.equals(distanceSign)) {
            return true;
        }
        return false;
    }

    public boolean isTimeSign(String sign) {
        if (sign.equals(timeSign)) {
            return true;
        }
        return false;
    }
}
